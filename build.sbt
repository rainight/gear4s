name := "gear4s"
 
version := "1.0"

lazy val commonSettings = Seq(
    scalaVersion := "2.11.11",
    scalacOptions ++= Seq("-feature", "-deprecation"),
    javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M", "-XX:+CMSClassUnloadingEnabled"),
    resolvers ++= Seq(
      "cdf repo" at "https://bams-sami.int.thomsonreuters.com/artifactory/default.maven.global/cdf",
      "cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/"
    )
)

lazy val root = (project in file("."))
  .aggregate(lib_utility, lib_hbase)

lazy val lib_utility = (project in file("lib-utility")).settings(commonSettings: _*)

lazy val lib_hbase = (project in file("lib-hbase")).settings(commonSettings: _*)

lazy val eg_antlr4 = (project in file("eg-antlr4")).settings(commonSettings: _*)

lazy val lib_spark = (project in file("lib-spark")).settings(commonSettings: _*) dependsOn (lib_hbase)

lazy val eg_cdf = (project in file("eg-cdf")).settings(commonSettings: _*) dependsOn (lib_hbase)