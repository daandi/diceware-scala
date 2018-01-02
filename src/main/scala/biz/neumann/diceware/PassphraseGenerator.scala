package biz.neumann.diceware
import scala.collection.immutable
import scala.util.Random._

trait PassphraseGenerator {

  def lookupDicethrow: Dicethrow => Option[Word]

  def generate(numberOfWords: Int, separator: String = "-") : Passphrase =
   generateDicewareThrows(numberOfWords)
      .map(lookupDicethrow)
      .flatten
      .mkString(separator)

  private def generateDicewareThrows(numOfThrows: Int): List[Dicethrow] =
    1.to(numOfThrows).toList.map(_ => throw5dices())

  /*the diceware lookup table is indexed with a 5 digit base 6 system */
  def throw5dices() : Dicethrow = 1.to(5).map(_ => nextInt(6) + 1).toList

}
