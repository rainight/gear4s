name := "lib-hbase"
 
version := "1.0"
 
val scalatest           = "org.scalatest" %% "scalatest" % "3.0.1" % "test"

val hadoop_version      = "2.6.0"
val hbase_version       = "1.0.3"
val hbase_common        = "org.apache.hbase" % "hbase-common" % hbase_version
val hbase_client        = "org.apache.hbase" % "hbase-client" % hbase_version
//val hbase_server        = "org.apache.hbase" % "hbase-server" % hbase_version excludeAll ExclusionRule ( organization = "org.mortbay.jetty")
val hbase_server        = "org.apache.hbase" % "hbase-server" % hbase_version
//val hadoop_common       = "org.apache.hadoop" % "hadoop-common" % hadoop_version excludeAll ExclusionRule (organization = "javax.servlet")
val hadoop_common       = "org.apache.hadoop" % "hadoop-common" % hadoop_version
val hadoop_hdfs         = "org.apache.hadoop" % "hadoop-hdfs" % hadoop_version
val hbase_hadoop_compat = "org.apache.hbase" % "hbase-hadoop-compat" % hbase_version

libraryDependencies ++= Seq(scalatest,
  hbase_common, hbase_client, hbase_server, hadoop_common, hbase_hadoop_compat
)
