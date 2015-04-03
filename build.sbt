
scalaVersion := "2.11.4"

name := "Codeforces"

version := "0.1-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
)


excludeFilter in unmanagedSources := "*.java"
