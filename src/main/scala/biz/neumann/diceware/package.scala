package biz.neumann

import biz.neumann.diceware.helpers.{PassphraseGenerator, Wordlist}

package object diceware {
  type Dicethrow = List[Int]
  type Passphrase = String
  type Word = String

  case class PassphraseFor(pathToWordlistResoure: String) extends PassphraseGenerator {
    val lexikon = new Wordlist(pathToWordlistResoure)
    override def lookupDicethrow: Dicethrow => Option[Passphrase] = lexikon lookupDicethrow _
  }

  /* English */
  lazy val default = PassphraseFor("/wordlists/diceware.wordlist.asc")
  lazy val english = default

  /* King James Bible for the religious type */
  lazy val kingJames = PassphraseFor("/wordlists/king_james_wordlist.txt")

  /* Lord of the Rings */
  lazy val lordOfTheRings = PassphraseFor("/wordlists/lotr.txt")



}
