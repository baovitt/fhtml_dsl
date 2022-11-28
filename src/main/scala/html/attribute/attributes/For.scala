package fhtml.attributes

import fhtml.*

class For(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("label", "output")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"label" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"output" -> (
					Chrome( "10.0"),
					Edge(   ""),
					Firefox("4.0"),
					Opera(  "11.0"),
					Safari( "5.1")
				)
			)
		)

	def getAttribute:            String = s"for=\"$suffix\""
	def getSuffix:               String = suffix

object For:
	def apply(): For = new For(false)
	def w(): For = new For(true)

	def :-(suffixValue: String): For = 
		var ret = new For(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): For = 
		var ret = new For(true)
		ret.suffix = suffixValue
		ret