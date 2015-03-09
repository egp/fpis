lazy val root = (project in file(".")).
  settings(
    name := "fpinscala",
    version := "1.0",
    scalaVersion := "2.11.6"
  )

// Change this to another test framework if you prefer
libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test"

//libraryDependencies += "com.typesafe.akka" % "akka-actor_2.11" % "2.3.3"

