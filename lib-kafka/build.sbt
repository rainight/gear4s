name := "lib-kafka"

version := "1.0"

val scalatest = "org.scalatest" %% "scalatest" % "3.0.1" % "test"

lazy val kafka = "org.apache.kafka" %% "kafka" % "0.8.2.1"

libraryDependencies ++= Seq(scalatest, kafka)