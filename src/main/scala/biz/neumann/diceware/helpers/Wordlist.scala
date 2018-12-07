package biz.neumann.diceware.helpers

import biz.neumann.diceware.{Dicethrow, Word}
import scala.io.Source

class Wordlist(src: Source) {
  private def numberStringToIntegers(s: String) = s.toList.map(_.toString.toInt)
  private val words : Map[Dicethrow, Word] = src
    .getLines()
    .filterNot(_.startsWith("#")) // not part of default implementation but allows to add comments with # in dicefiles
    .foldLeft(List.empty[(Dicethrow, Word)]){ case (acc, line) =>
      val Array(key, word) = line.split("\t")
      (numberStringToIntegers(key), word) :: acc
    }.toMap

  def lookupDicethrow(dicethrow: Dicethrow) : Option[Word] = words get dicethrow
}

object Wordlist {
  def fromResource(resource: String) = {
    val is = getClass.getResourceAsStream(resource)
    new Wordlist(Source.fromInputStream(is)("utf-8"))
  }
}
