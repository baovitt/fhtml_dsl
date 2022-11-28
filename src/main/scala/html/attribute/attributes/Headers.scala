package fhtml.attributes

import fhtml.*

class Headers(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("td", "th")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"td" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"th" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"headers=\"$suffix\""
	def getSuffix:               String = suffix

object Headers:
	def apply(): Headers = new Headers(false)
	def w(): Headers = new Headers(true)

	def :-(suffixValue: String): Headers = 
		var ret = new Headers(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Headers = 
		var ret = new Headers(true)
		ret.suffix = suffixValue
		ret