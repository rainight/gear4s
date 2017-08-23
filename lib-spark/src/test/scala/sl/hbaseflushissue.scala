package sl

import java.util.Calendar

import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}
import com.holdenkarau.spark.testing.{RDDComparisons, SharedSparkContext}
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}
import org.apache.hadoop.hbase.client.{ConnectionFactory, HTable, Put}
import org.apache.log4j.LogManager

import scala.collection.mutable

/**
  * Created by liush on 06/06/2017.
  */
object hh {
  class Pool[K, V] {
    val queues = new mutable.HashMap[K, mutable.Queue[V]]

    def get(key: K)(op: => V): V = {
      queues.synchronized {
        queues.get(key) match {
          case Some(q) =>
            if (q.isEmpty) op else q.dequeue()
          case None => op
        }
      }
    }

    def ret(key: K, v: V) = {
      queues.synchronized {
        queues.get(key) match {
          case Some(q) => q.enqueue(v)
          case None =>
            val q = mutable.Queue.empty[V]
            q.enqueue(v)
            queues(key) = q
        }
      }
    }

  }

  val logger = LogManager.getLogger("hh")

  class HTablex(conf: Configuration, name: String) extends HTable(conf, name) {
    val t = java.util.UUID.randomUUID().toString
  }

  val tables = new Pool[String, HTablex]
  def getTable(conf: Configuration, typeName: String, taskName: String): HTablex = {
    val key = typeName
    val t = tables.get(key) {
      new HTablex(conf, typeName)
    }

    sf(s"${Calendar.getInstance().getTimeInMillis.toString} task $taskName: rent ${t.t} ++\n ")
    t
  }

  def retTable(typeName: String, table: HTablex, taskName: String) = {
    val key = typeName
    tables.ret(key, table)

    sf(s"${Calendar.getInstance().getTimeInMillis.toString} task $taskName: return ${table.t} --\n ")
  }

  def flushTables(taskName: String) = {
    sf(s"task $taskName: flush\n")
    tables.queues.foreach(kv =>
      kv._2.foreach(t => { t.flushCommits(); sf(s"${Calendar.getInstance().getTimeInMillis.toString} flush ${t.t} ||\n "); logger.info(s"flush ${t.t} || ") })
    )
  }

  def hput(p: Iterator[(String, String, String, String)]): Iterator[String] = {
    val ps = java.util.UUID.randomUUID().toString.takeRight(3)

    if(p.isEmpty) return Iterator.empty

    val hconf = HBaseConfiguration.create()

    hconf.set("hbase.zookeeper.quorum", "adccdha,adccdhb,adccdhc")
    hconf.set("hbase.zookeeper.property.clientPort", "2181")

    val tb = hh.getTable(hconf, "shawn:testing", ps)
    tb.setAutoFlushTo(false)

    val ret = p.map { case (key, f, qual, v) =>
      val t = Calendar.getInstance()
      val p = new Put(Bytes.toBytes(key))
      p.addColumn(Bytes.toBytes(f), Bytes.toBytes(qual), Bytes.toBytes(t.getTimeInMillis.toString + v))
      tb.put(p)

      s"${t.getTimeInMillis.toString}|$ps table ${tb.t} put $key $f $qual $v with \n $error <<"
    }

    tb.flushCommits()
    sf(s"${Calendar.getInstance().getTimeInMillis.toString} task $ps: flush ${tb.t}\n ")
    hh.retTable("autocreate1", tb, ps)

    ret
  }

  var error = ""
  def sf(s: String) = {
    error.synchronized {
      error += s
    }
  }
}

class hbaseflushissue extends FunSuite with Matchers with SharedSparkContext {
  val operationlist = List(("abcd", "cf", "123", "this is testing"), ("abcd", "cf", "123", "whos your dad"), ("efgh", "cf", "456", "show me the money"), ("efgh", "cf", "456", "i am you father!"))

  /*test("base ops") {
    val r = hh.hput(operationlist.toIterator)
    r.foreach(println)
  }*/

  test("input hbase with HTable") {
     val rdd = sc.parallelize(operationlist).repartition(100)
     rdd.mapPartitions { case p => hh.hput(p) }.collect().foreach(x => println(x + "\n------------------------------------------------------\n"))

     println(hh.error)
  }
}
