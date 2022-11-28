package fhtml.attributes

import fhtml.*

class Min(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "meter")
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
					Chrome( "5.0"),
					Edge(   "10.0"),
					Firefox("16.0"),
					Opera(  "10.6"),
					Safari( "5.1")
				)
			)
		)

	def getAttribute:            String = s"min=\"$suffix\""
	def getSuffix:               String = suffix

object Min:
	def apply(): Min = new Min(false)
	def w(): Min = new Min(true)

	def :-(suffixValue: String): Min = 
		var ret = new Min(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Min = 
		var ret = new Min(true)
		ret.suffix = suffixValue
		ret