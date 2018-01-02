package biz.neumann.diceware

import org.scalatest.prop.PropertyChecks
import org.scalatest.{FunSpec, Matchers}

class PassphraseGeneratorTest extends FunSpec with Matchers   {


  describe("Diceware Generator") {

    it("can generates correct diceware throws with numbers from 1 to 6") {
      val noWordGenerator = new PassphraseGenerator {
        override def lookupDicethrow = _ => None
      }

      val d = noWordGenerator.throw5dices()
      d should have size 5
      d should contain only (1, 2, 3, 4, 5, 6)
    }

    it("can generate a diceware passphrase of the correct length") {
      val sameWordGenerator = new PassphraseGenerator {
        override def lookupDicethrow = _=> Some("rosebud")
      }

      val i = 10
      val sep = "_"
      val passphrase = sameWordGenerator.generate(numberOfWords = i, separator = sep)
      passphrase.split(sep) should have size(i)
    }
  }
}
