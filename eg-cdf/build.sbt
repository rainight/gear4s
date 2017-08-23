name := "eg-cdf"
 
version := "1.0"

val scalatest = "org.scalatest" %% "scalatest" % "3.0.1" % "test"

val cdfsdk = "com.thomsonreuters.cdf" % "cdf-sdk" % "2017.08.20"

libraryDependencies ++= Seq(scalatest, cdfsdk)