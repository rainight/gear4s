name := "lib-spark"
 
version := "1.0"
 
val scalatest           = "org.scalatest" %% "scalatest" % "3.0.1" % "test"

val spark_version       = "2.1.1"
val spark_core          = "org.apache.spark" %% "spark-core" % spark_version % "provided"
val spark_sql           = "org.apache.spark" %% "spark-sql" % spark_version % "provided"
val spark_hive          = "org.apache.spark" %% "spark-hive" % spark_version % "provided"
val spark_streaming     = "org.apache.spark" %% "spark-streaming" % spark_version % "provided"

val spark_test          = "com.holdenkarau" %% "spark-testing-base" % "2.1.0_0.6.0" % "test"

val avro_version        = "1.8.2"
val avro                = "org.apache.avro" % "avro" % avro_version

libraryDependencies ++= Seq(scalatest,
  spark_core, spark_sql, spark_hive, spark_streaming, spark_test, avro
)
