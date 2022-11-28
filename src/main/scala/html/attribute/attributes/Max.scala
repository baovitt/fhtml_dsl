package fhtml.attributes

import fhtml.*

class Max(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "meter", "progress")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"input" -> (
					Chrome( "5.0"),
					Edge(   "10.0"),
					Firefox("16.0"),
					Opera(  "10.6"),
					Safari( "5.1")
				),
				"meter" -> (
					Chrome( "8.0"),
					Edge(   ""),
					Firefox("6.0"),
					Opera(  "11.0"),
					Safari( "6.0")
				),
				"progress" -> (
					Chrome( "8.0"),
					Edge(   "10.0"),
					Firefox("16.0"),
					Opera(  "11.0"),
					Safari( "6.0")
				)
			)
		)

	def getAttribute:            String = s"max=\"$suffix\""
	def getSuffix:               String = suffix

object Max:
	def apply(): Max = new Max(false)
	def w(): Max = new Max(true)

	def :-(suffixValue: String): Max = 
		var ret = new Max(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Max = 
		var ret = new Max(true)
		ret.suffix = suffixValue
		ret