import scala.io.Source

import java.io._
val pw = new PrintWriter(new File("/Users/andi/src/diceware-scala/src/main/resources/wordlists/lotr.txt" ), "UTF-8")
val bible = "/Users/andi/Desktop/lotr.txt"
val word = "[A-Za-z]+".r
val wordFrq = Source
  .fromFile(bible)
  .getLines()
  .flatMap(word.findAllIn)
  .toVector
  .groupBy(word => word.toLowerCase)
  .mapValues(_.size)
  .toVector
  .sortBy(_._2)
  .reverse
  .take(7776)
  .sortBy(_._1)

wordFrq.zipWithIndex.foreach { case ((word,_),idx) =>
  val dicewareIndex = {
    val base6 = BigInt(idx).toString(6)
    val leftPadding : String = {
      val padding = 5 - base6.length
      1.to(padding).foldLeft(""){case (acc,_) => acc + "0"}
    }

    (leftPadding + base6).split("").map(_.toInt + 1).mkString

  }
  pw.println(s"$dicewareIndex\t$word")
}
pw.close







