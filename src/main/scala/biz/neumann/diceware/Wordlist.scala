package biz.neumann.diceware

import java.io.InputStream

import scala.io.Source

class Wordlist(path: String) {
  private val is : InputStream = getClass.getResourceAsStream(path)
  private def numberStringToIntegers(s: String) = s.toList.map(_.toString.toInt)
  private val words : Map[Dicethrow, Word] = Source.fromInputStream(is, "utf-8")
    .getLines()
    .filterNot(_.startsWith("#")) // not part of default implementation but allows to add comments with # in dicefiles
    .foldLeft(List.empty[(Dicethrow, Word)]){ case (acc, line) =>
      val Array(key, word) = line.split("\t")
      (numberStringToIntegers(key), word) :: acc
    }.toMap

  def lookupDicethrow(dicethrow: Dicethrow) : Option[Word] = words get dicethrow
}