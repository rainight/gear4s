name := "eg-antlr4"
 
version := "1.0"
 
val scalatest           = "org.scalatest" %% "scalatest" % "3.0.1" % "test"

val antlr_runtime       = "org.antlr" % "antlr4-runtime" % "4.7"

libraryDependencies ++= Seq(scalatest,
  antlr_runtime
)