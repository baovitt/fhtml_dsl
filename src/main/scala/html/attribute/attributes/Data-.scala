package fhtml.attributes

import fhtml.*

class `Data-`(nameAddition: String)(showWarning: Boolean) 
		extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"Global Attribute" -> (
					Chrome( "4.0"),
					Edge(   "5.5"),
					Firefox("2.0"),
					Opera(  "9.6"),
					Safari( "3.1")
				)
			)
		)

	def getAttribute:            String = s"data-$nameAddition=\"$suffix\""
	def getSuffix:               String = suffix

object `Data-`:
	def apply(): `Data-` = new `Data-`("")(false)
	def w(): `Data-` = new `Data-`("")(true)

	def :-(name: String, suffixValue: String): `Data-` = 
		var ret = new `Data-`(name)(false)
		ret.suffix = suffixValue
		ret

	def :*(name: String, suffixValue: String): `Data-` = 
		var ret = new `Data-`(name)(true)
		ret.suffix = suffixValue
		ret
