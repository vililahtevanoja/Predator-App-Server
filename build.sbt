name := """predatorapp"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

dependencyOverrides += "org.scala-lang" % "scala-compiler" % scalaVersion.value

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  filters,
  specs2 % Test,
  "com.typesafe.play" %% "play-slick" % "2.0.0",
  "com.h2database" % "h2" % "1.4.192",
  "com.typesafe.akka" % "akka-stream_2.11" % "2.4.10",
  "com.typesafe.akka" % "akka-slf4j_2.11" % "2.4.10",
  "com.mohiva" % "play-silhouette_2.11" % "4.0.0",
  "org.julienrf" % "play-json-derived-codecs_2.11" % "3.0",
  "org.scalactic" %% "scalactic" % "3.0.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % "test",
  "org.scalamock" %% "scalamock-scalatest-support" % "3.2.2" % "test"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers += Resolver.sonatypeRepo("releases")
resolvers += "Atlassian Releases" at "https://maven.atlassian.com/public/"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
