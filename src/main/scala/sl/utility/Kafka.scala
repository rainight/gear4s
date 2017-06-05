package sl.utility

import java.util.Properties
import java.util.concurrent.Future

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord, RecordMetadata}

/**
  * Created by liush on 05/06/2017.
  */
object Kafka {
  val effectiveConfig = (brokers: String, conf: Properties) => {
    val p = new Properties
    p.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokers)
    p.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArraySerializer")
    p.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.ByteArraySerializer")
    p.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, "snappy")
    p.put(ProducerConfig.ACKS_CONFIG, "1")
    p.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, "1")  // order is guaranteed when retry
    p.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, "200000000")
    p.put(ProducerConfig.LINGER_MS_CONFIG, "30000")
    p.put(ProducerConfig.BATCH_SIZE_CONFIG, "10240")
    p.put(ProducerConfig.BUFFER_MEMORY_CONFIG, "500000000")
    p.put(ProducerConfig.RETRIES_CONFIG, "5")
    p.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, "1000")
    p.put(ProducerConfig.TIMEOUT_CONFIG, "60000")
    p.putAll(conf)
    p
  }

  def apply(brokers: String): Kafka = new Kafka(effectiveConfig(brokers, new Properties()))

  def apply(brokers: String, conf: Properties): Kafka = new Kafka(effectiveConfig(brokers, conf))
}

class Kafka(conf: Properties) {
  type Key = Array[Byte]
  type Val = Array[Byte]

  val producer = new KafkaProducer[Array[Byte], Array[Byte]](conf)

  /**
    * send a single message, synchronized
    *
    * @param topic
    * @param key
    * @param value
    * @return
    */
  def send(topic: String, key: Key, value: Val) = {
    val m = new ProducerRecord[Key, Val](topic, key, value)
    producer.send(m).get()
  }

  /**
    * send list of messages with specified topic for each
    * will wait on response for last message
    * @param topicKeyValueMessages list of (topic, key, value)
    */
  def batchSend(topicKeyValueMessages: Iterable[(String, Key, Val)]): Unit  = {
    if(topicKeyValueMessages.isEmpty){
      return
    }

    var res: Future[RecordMetadata] = null
    topicKeyValueMessages.foreach { case(topic, key, value) =>
      val m = new ProducerRecord[Key, Val](topic, key, value)
      res = producer.send(m)
    }
    val metadata = res.get()
    if(metadata == null)
      throw new Exception("Fail to send message to Kafka.")
  }

  /**
    * send list of messages of same topic, asynchronized
    * will wait on response for last message
    * @param topic
    * @param keyValueMessages list of (key, message)
    */
  def batchSend(topic: String, keyValueMessages: Iterable[(Key, Val)]): Unit = {
    batchSend(keyValueMessages.map { case (key, value) => (topic, key, value)})
  }

  def close(): Unit = producer.close()
}
