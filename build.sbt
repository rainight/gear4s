name := "gear4s"
 
version := "1.0"
 
scalaVersion := "2.11.11"

val j4sversion          = "3.3.0"
val json4sNative        = "org.json4s" %% "json4s-native" % j4sversion
val json4sJackson       = "org.json4s" %% "json4s-jackson" % j4sversion

val avro_version        = "1.8.2"
val avro                = "org.apache.avro" % "avro" % avro_version

val scalatest           = "org.scalatest" %% "scalatest" % "3.0.1" % "test"

val hadoop_version      = "2.6.0"
val hbase_version       = "1.0.3"
val hbase_common        = "org.apache.hbase" % "hbase-common" % hbase_version
val hbase_client        = "org.apache.hbase" % "hbase-client" % hbase_version
val hbase_server        = "org.apache.hbase" % "hbase-server" % hbase_version excludeAll ExclusionRule ( organization = "org.mortbay.jetty")
val hadoop_common       = "org.apache.hadoop" % "hadoop-common" % hadoop_version excludeAll ExclusionRule (organization = "javax.servlet")
val hadoop_hdfs         = "org.apache.hadoop" % "hadoop-hdfs" % hadoop_version
val hbase_hadoop_compat = "org.apache.hbase" % "hbase-hadoop-compat" % hbase_version

val kafka               = "org.apache.kafka" %% "kafka" % "0.8.2.2"

val spark_version       = "2.1.1"
val spark_core          = "org.apache.spark" %% "spark-core" % spark_version % "provided"
val spark_sql           = "org.apache.spark" %% "spark-sql" % spark_version % "provided"
val spark_hive          = "org.apache.spark" %% "spark-hive" % spark_version % "provided"
val spark_streaming     = "org.apache.spark" %% "spark-streaming" % spark_version % "provided"

val spark_test          = "com.holdenkarau" %% "spark-testing-base" % "2.1.0_0.6.0" % "test"
 
libraryDependencies ++= Seq(json4sNative, json4sJackson, avro, scalatest,
  hbase_common, hbase_client, hbase_server, hadoop_common, hadoop_hdfs, hbase_hadoop_compat,
  kafka, spark_core, spark_sql, spark_hive, spark_streaming, spark_test
)

scalacOptions += "-deprecation"
 
initialCommands in console := """
    |import org.json4s._
    |import org.json4s.native.JsonMethods._
    |import org.json4s.JsonDSL._
    |import org.apache.avro._
    |""".stripMargin

javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled")
