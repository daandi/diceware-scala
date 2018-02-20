package biz.neumann

import biz.neumann.diceware.helpers.{PassphraseGenerator, Wordlist}

package object diceware {
  type Dicethrow = List[Int]
  type Passphrase = String
  type Word = String

  lazy val default = new PassphraseGenerator {
    val lexikon = new Wordlist("/wordlists/diceware.wordlist.asc")
    override def lookupDicethrow: Dicethrow => Option[Passphrase] = lexikon lookupDicethrow _
  }

  lazy val english = default



}
