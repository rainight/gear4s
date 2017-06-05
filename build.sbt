name := "gear4s"
 
version := "1.0"
 
scalaVersion := "2.11.11"

val j4sversion = "3.3.0"
val json4sNative = "org.json4s" %% "json4s-native" % j4sversion
val json4sJackson = "org.json4s" %% "json4s-jackson" % j4sversion

val avro_version = "1.8.2"
val avro = "org.apache.avro" % "avro" % avro_version

val scalatest = "org.scalatest" %% "scalatest" % "3.0.1" % "test"

val hadoop_version = "2.6.0"
val hbase_version = "1.0.3"
lazy val hbase_common = "org.apache.hbase" % "hbase-common" % hbase_version
lazy val hbase_client = "org.apache.hbase" % "hbase-client" % hbase_version
lazy val hbase_server = "org.apache.hbase" % "hbase-server" % hbase_version
lazy val hadoop_common = "org.apache.hadoop" % "hadoop-common" % hadoop_version
lazy val hadoop_hdfs = "org.apache.hadoop" % "hadoop-hdfs" % hadoop_version
lazy val hbase_hadoop_compat = "org.apache.hbase" % "hbase-hadoop-compat" % hbase_version

val kafka = "org.apache.kafka" %% "kafka" % "0.8.2.2"
 
libraryDependencies ++= Seq(json4sNative, json4sJackson, avro, scalatest,
  hbase_common, hbase_client, hbase_server, hadoop_common, hadoop_hdfs, hbase_hadoop_compat,
  kafka
)

scalacOptions += "-deprecation"
 
initialCommands in console := """
    |import org.json4s._
    |import org.json4s.native.JsonMethods._
    |import org.json4s.JsonDSL._
    |import org.apache.avro._
    |""".stripMargin

