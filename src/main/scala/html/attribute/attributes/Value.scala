package fhtml.attributes

import fhtml.*

class Value(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("button", "input", "li", "meter", "option", "progress", "param")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"button" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"input" -> (
					Chrome( "1.0"),
					Edge(   "2.0"),
					Firefox("1.0"),
					Opera(  "1.0"),
					Safari( "1.0")
				),
				"li" -> (
					Chrome( "1.0"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "1.0"),
					Safari( "1.0")
				),
				"meter" -> (
					Chrome( "8.0"),
					Edge(   "13.0"),
					Firefox("6.0"),
					Opera(  "11.0"),
					Safari( "61.0")
				),
				"option" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"progress" -> (
					Chrome( "8.0"),
					Edge(   "10.0"),
					Firefox("16.0"),
					Opera(  "11.0"),
					Safari( "6.0")
				),
				"param" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"value=\"$suffix\""
	def getSuffix:               String = suffix

object Value:
	def apply(): Value = new Value(false)
	def w(): Value = new Value(true)

	def :-(suffixValue: String): Value = 
		var ret = new Value(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Value = 
		var ret = new Value(true)
		ret.suffix = suffixValue
		ret