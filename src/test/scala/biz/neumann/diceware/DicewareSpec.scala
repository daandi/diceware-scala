package biz.neumann.diceware

import org.scalatest.{FunSpec, FunSuite, Matchers}

class DicewareSpec extends FunSpec with Matchers {

  describe("Standard Generator") {
    val numOfWords = 10
    val sep = "-"
    val passphrase = standardGenerator.generate(numOfWords,sep)

    it(s"should contain of $numOfWords seperated by $sep") {
      info(s"Generated Passphrase: $passphrase")

      passphrase.split(sep) should have size numOfWords
    }

  }

}
