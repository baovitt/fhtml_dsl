package fhtml.attributes

import fhtml.*

class Method(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("form")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"form" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"method=\"$suffix\""
	def getSuffix:               String = suffix

object Method:
	def apply(): Method = new Method(false)
	def w(): Method = new Method(true)

	def :-(suffixValue: String): Method = 
		var ret = new Method(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Method = 
		var ret = new Method(true)
		ret.suffix = suffixValue
		ret