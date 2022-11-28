package fhtml.attributes

import fhtml.*

class Class(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"Global Attributes" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"class=\"$suffix\""
	def getSuffix:               String = suffix

object Class:
	def apply(): Class = new Class(false)
	def w(): Class = new Class(true)

	def :-(suffixValue: String): Class = 
		var ret = new Class(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Class = 
		var ret = new Class(true)
		ret.suffix = suffixValue
		ret
