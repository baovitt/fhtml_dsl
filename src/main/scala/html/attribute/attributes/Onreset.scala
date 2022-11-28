package fhtml.attributes

import fhtml.*

class Onreset(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onreset=\"$suffix\""
	def getSuffix:               String = suffix

object Onreset:
	def apply(): Onreset = new Onreset(false)
	def w(): Onreset = new Onreset(true)

	def :-(suffixValue: String): Onreset = 
		var ret = new Onreset(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onreset = 
		var ret = new Onreset(true)
		ret.suffix = suffixValue
		ret