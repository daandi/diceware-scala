# Diceware for scala

This library written in Scala provides passphrase generators for english and german and means to generate one's own passphrase generators by providing an input text.

# Diceware
Diceware is a approach to passpharse geneeration that aims to generate easy to remember passphrases.

[https://en.wikipedia.org/wiki/Diceware]

[http://world.std.com/~reinhold/diceware.html]

# Passphrase generators
## Usage
```scala
import biz.neumann.diceware._

standardGenerator.generate(numberOfWords = 5, separator = "-")

//res0: biz.neumann.diceware.Passphrase = zm-abash-par-heck-23



standardGenerator.generate(numberOfWords = 6, separator = ".")

//res1: biz.neumann.diceware.Passphrase = def.76.fink.cia.balsa.fifth

```