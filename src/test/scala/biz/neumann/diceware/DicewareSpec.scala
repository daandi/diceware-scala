package biz.neumann.diceware

import org.specs2.{ScalaCheck, Specification}

class DicewareSpec extends Specification with ScalaCheck {def is = s2"""
  Diceware Generators generate passphrases for
    english native speakers                   $standardGeneratorTest
  """

  def standardGeneratorTest = {
    val numOfWords = 10
    val sep = "-"
    val passphrase = standardGenerator.generate(numOfWords,sep)

    passphrase.split(sep) must have size(numOfWords)
  }
}
