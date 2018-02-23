# Diceware for scala

This library written in Scala provides passphrase generators for english and german and means to generate one's own passphrase generators by providing an input text.

# Diceware
Diceware is a approach to passpharse geneeration that aims to generate easy to remember passphrases.

[https://en.wikipedia.org/wiki/Diceware]

[http://world.std.com/~reinhold/diceware.html]

## Why this implementation ?
A password gets easier to remember if it can be connected to a story, is funny or somehow feels interesting to you.
Tastes differ, 

# Passphrase generators
## Usage
```scala
import biz.neumann.diceware._

english.generate(numberOfWords = 6, separator = ".")
//res1: biz.neumann.diceware.Passphrase = def.76.fink.cia.balsa.fifth

kingJames.generate(numberOfWords = 5, separator = "-")
//res10: biz.neumann.diceware.Passphrase = touched-Asuppim-thick-Marcus-evangelist

```