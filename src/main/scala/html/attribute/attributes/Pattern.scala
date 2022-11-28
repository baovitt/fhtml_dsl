package fhtml.attributes

import fhtml.*

class Pattern(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"input" -> (
					Chrome( "5.0"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "9.6"),
					Safari( "")
				)
			)
		)

	def getAttribute:            String = s"pattern=\"$suffix\""
	def getSuffix:               String = suffix

object Pattern:
	def apply(): Pattern = new Pattern(false)
	def w(): Pattern = new Pattern(true)

	def :-(suffixValue: String): Pattern = 
		var ret = new Pattern(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Pattern = 
		var ret = new Pattern(true)
		ret.suffix = suffixValue
		ret