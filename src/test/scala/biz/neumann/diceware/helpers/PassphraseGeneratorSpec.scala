package biz.neumann.diceware.helpers

import biz.neumann.diceware.Dicethrow
import org.scalacheck.{Arbitrary}
import org.specs2.{ScalaCheck, Specification}


class PassphraseGeneratorSpec extends Specification with ScalaCheck {def is = s2"""
  Diceware Generator

  The Passphrase Generator
    generates passphrases with the correct length                    $correctLength

  The dice throws
    all throws are between 1 and 6                                   ${Dicetrhows.diceValues}
    all throw results have 5 digits                                  ${Dicetrhows.fiveDigits}
  """

  def correctLength =  {
    val sameWordGenerator = new PassphraseGenerator {
      override def lookupDicethrow = _=> Some("rosebud")
    }
  val i = 10
  val sep = "_"
  val passphrase = sameWordGenerator.generate(numberOfWords = i, separator = sep)

    passphrase.split(sep) must have size(i)
  }

  object Dicetrhows {
    val noWordGenerator = new PassphraseGenerator {override def lookupDicethrow = _ => None}
    implicit def abitraryDicethrow: Arbitrary[Dicethrow] = Arbitrary(noWordGenerator.throw5dices())

    def beBetween(i: Int, j: Int) = be_>=(i) and be_<=(j)

    def diceValues = prop ((dicethrow: Dicethrow) =>  dicethrow must contain(beBetween(1,6)).forall )
    def fiveDigits = prop ((diceThrow: Dicethrow) => diceThrow must have size(5))
  }


}
