package biz.neumann

package object diceware {
  type Dicethrow = List[Int]
  type Passphrase = String
  type Word = String

  lazy val standardGenerator = new PassphraseGenerator {
    val lexikon = new Wordlist("/diceware.wordlist.asc")

    override def lookupDicethrow: Dicethrow => Option[Passphrase] =
      lexikon lookupDicethrow _
  }
}
