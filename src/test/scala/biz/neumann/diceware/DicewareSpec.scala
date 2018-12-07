package biz.neumann.diceware

import biz.neumann.diceware.helpers.PassphraseGenerator
import org.specs2.Specification

class DicewareSpec extends Specification {def is = s2"""
  Diceware Generators generate passphrases with
    the expected configuration    $configurationTest
    german words                  ${genTest(german)}
  """

  def configurationTest = {
    val numOfWords = 4
    val sep = "-"
    val passphrase = default.generate(numOfWords,sep)

    passphrase.split(sep) must have size(numOfWords)
  }

  def genTest(gen: PassphraseGenerator) = gen must not throwA[NullPointerException]()

}
