package biz.neumann

package object diceware {
  type Dicethrow = List[Int]
  type Passphrase = String
  type Word = String

  /* English */
  lazy val english = DicewareGenerator.fromResource("/wordlists/diceware.wordlist.asc")
  lazy val default = english

  /* King James Bible for the religious type */
  lazy val kingJames = DicewareGenerator.fromResource("/wordlists/king_james.diceware")

  /* German */
  lazy val german =  DicewareGenerator.fromResource("/wordlists/german_wordlist.diceware")
}
