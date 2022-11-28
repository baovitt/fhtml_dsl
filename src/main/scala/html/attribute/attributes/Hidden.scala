package fhtml.attributes

import fhtml.*

class Hidden(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"Global Attribute" -> (
					Chrome( "6.0"),
					Edge(   "11.0"),
					Firefox("4.0"),
					Opera(  "11.1"),
					Safari( "5.1")
				)
			)
		)

	def getAttribute:            String = "hidden"
	def getSuffix:               String = suffix

object Hidden:
	def apply(): Hidden = new Hidden(false)
	def w(): Hidden = new Hidden(true)

	def :-(suffixValue: String): Hidden = 
		var ret = new Hidden(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Hidden = 
		var ret = new Hidden(true)
		ret.suffix = suffixValue
		ret