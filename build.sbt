import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "biz.neumann",
      scalaVersion := "2.12.4",
      version      := "0.1.0-SNAPSHOT",
      scalacOptions in Test ++= Seq("-Yrangepos")
    )),
    name := "diceware",
    libraryDependencies ++= List(
      specs2 % Test,
      specs2Scalacheck % Test
    )
  )
