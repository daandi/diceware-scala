import sbt._

object Dependencies {
  val specs2V = "4.0.3"
  val specs2Scalacheck = "org.specs2" %% "specs2-scalacheck" % specs2V
  val specs2 = "org.specs2" %% "specs2-tests" % specs2V
  val tagsoup =  "org.ccil.cowan.tagsoup" % "tagsoup" % "1.2.1"
}
