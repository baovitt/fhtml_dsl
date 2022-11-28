package fhtml.attributes

import fhtml.*

class Shape(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("area")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"area" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"shape=\"$suffix\""
	def getSuffix:               String = suffix

object Shape:
	def apply(): Shape = new Shape(false)
	def w(): Shape = new Shape(true)

	def :-(suffixValue: String): Shape = 
		var ret = new Shape(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Shape = 
		var ret = new Shape(true)
		ret.suffix = suffixValue
		ret