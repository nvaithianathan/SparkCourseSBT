name := "SparkCourseSBT"

version := "0.1"

scalaVersion := "2.11.8"

val sparkVersion = "2.4.3"
val jacksonVersion = "2.9.0"

// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion

//logging



//logging
libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.25"
libraryDependencies += "org.slf4j" % "log4j-over-slf4j" % "1.7.25"
libraryDependencies += "com.arpnetworking.logback" % "logback-steno" % "1.18.0"

excludeDependencies ++= Seq("log4j" % "log4j", "org.slf4j" % "slf4j-log4j12")

//resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
//resolvers ++= Seq(
//  "Groupon Releases" at "http://nexus-dev/content/repositories/releases/",
//  "Groupon Snapshot" at "http://nexus-dev/content/groups/public-snapshots/"
//)


// for json
// for json
libraryDependencies ++=
  Seq("com.fasterxml.jackson.core" % "jackson-databind" % jacksonVersion
    ,"com.fasterxml.jackson.module" %% "jackson-module-scala" % jacksonVersion
    ,"com.fasterxml.jackson.datatype" % "jackson-datatype-joda" % jacksonVersion
  )

libraryDependencies += "org.joda" % "joda-convert" % "1.9.1"


