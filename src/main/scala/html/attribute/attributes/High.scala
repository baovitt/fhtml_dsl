package fhtml.attributes

import fhtml.*

class High(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("meter")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"meter" -> (
					Chrome( "8.0"),
					Edge(   ""),
					Firefox("6.0"),
					Opera(  "11.0"),
					Safari( "6.0")
				)
			)
		)

	def getAttribute:            String = s"high=\"$suffix\""
	def getSuffix:               String = suffix

object High:
	def apply(): High = new High(false)
	def w(): High = new High(true)

	def :-(suffixValue: String): High = 
		var ret = new High(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): High = 
		var ret = new High(true)
		ret.suffix = suffixValue
		ret