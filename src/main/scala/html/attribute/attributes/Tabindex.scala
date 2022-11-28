package fhtml.attributes

import fhtml.*

class Tabindex(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"tabindex=\"$suffix\""
	def getSuffix:               String = suffix

object Tabindex:
	def apply(): Tabindex = new Tabindex(false)
	def w(): Tabindex = new Tabindex(true)

	def :-(suffixValue: String): Tabindex = 
		var ret = new Tabindex(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Tabindex = 
		var ret = new Tabindex(true)
		ret.suffix = suffixValue
		ret