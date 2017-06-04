name := "gear4s"
 
version := "1.0"
 
scalaVersion := "2.11.11"

val j4sversion = "3.3.0"
val json4sNative = "org.json4s" %% "json4s-native" % j4sversion
val json4sJackson = "org.json4s" %% "json4s-jackson" % j4sversion

val avro_version = "1.8.2"
val avro = "org.apache.avro" % "avro" % avro_version

val scalatest = "org.scalatest" %% "scalatest" % "3.0.1" % "test"
 
libraryDependencies ++= Seq(json4sNative, json4sJackson, avro, scalatest)

scalacOptions += "-deprecation"
 
initialCommands in console := """
    |import org.json4s._
    |import org.json4s.native.JsonMethods._
    |import org.json4s.JsonDSL._
    |import org.apache.avro._
    |""".stripMargin

