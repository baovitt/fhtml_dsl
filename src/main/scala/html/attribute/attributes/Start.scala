package fhtml.attributes

import fhtml.*

class Start(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("ol")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"ol" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"start=\"$suffix\""
	def getSuffix:               String = suffix

object Start:
	def apply(): Start = new Start(false)
	def w(): Start = new Start(true)

	def :-(suffixValue: String): Start = 
		var ret = new Start(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Start = 
		var ret = new Start(true)
		ret.suffix = suffixValue
		ret