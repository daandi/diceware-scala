package biz.neumann.diceware

import biz.neumann.diceware.helpers.{PassphraseGenerator, Wordlist}

class DicewareGenerator(wordlist: Wordlist) extends PassphraseGenerator {
  override def lookupDicethrow: Dicethrow => Option[Passphrase] = wordlist.lookupDicethrow
}

object DicewareGenerator {
  def fromResource(resource : String) = new DicewareGenerator( Wordlist.fromResource(resource) )
}