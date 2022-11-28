package fhtml.attributes

import fhtml.*

class Low(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"low=\"$suffix\""
	def getSuffix:               String = suffix	

object Low:
	def apply(): Low = new Low(false)
	def w(): Low = new Low(true)

	def :-(suffixValue: String): Low = 
		var ret = new Low(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Low = 
		var ret = new Low(true)
		ret.suffix = suffixValue
		ret