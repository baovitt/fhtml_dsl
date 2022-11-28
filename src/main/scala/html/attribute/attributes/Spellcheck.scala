package fhtml.attributes

import fhtml.*

class Spellcheck(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"Global Attributes" -> (
					Chrome( "9.0"),
					Edge(   "10.0"),
					Firefox("2.0"),
					Opera(  "10.5"),
					Safari( "5.1")
				)
			)
		)

	def getAttribute:            String = s"spellcheck=\"$suffix\""
	def getSuffix:               String = suffix

object Spellcheck:
	def apply(): Spellcheck = new Spellcheck(false)
	def w(): Spellcheck = new Spellcheck(true)

	def :-(suffixValue: String): Spellcheck = 
		var ret = new Spellcheck(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Spellcheck = 
		var ret = new Spellcheck(true)
		ret.suffix = suffixValue
		ret