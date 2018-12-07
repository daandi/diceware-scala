# Diceware for Scala
This library generates passwords/passphrases using the diceware algorithm.

For a little more freedom and variance it comes with an english and german word list but also provides the means to generate one's own passphrase generators by providing a text source of your own choice.

# Diceware
Diceware is a approach to passpharse generation that aims to generate easy to remember passphrases.

[https://en.wikipedia.org/wiki/Diceware]

[http://world.std.com/~reinhold/diceware.html]

## Why this implementation ?
A password gets easier to remember if it can be connected to a story, is funny or somehow feels interesting to you.
Sometimes you do not have the time to think one up so this gerator provides something similar.

Sometimes you need to transfer a password by phone/voice. Image having to tell your old man over the phone to enter `V@2Qc$RM4!kYLdJeHF4#c` to be able to unlock the router at home.

# Passphrase generators
## Usage
```scala
import biz.neumann.diceware._

english.generate(numberOfWords = 6, separator = ".")
//res1: biz.neumann.diceware.Passphrase = def.76.fink.cia.balsa.fifth

kingJames.generate(numberOfWords = 5, separator = "-")
//res10: biz.neumann.diceware.Passphrase = touched-Asuppim-thick-Marcus-evangelist

```