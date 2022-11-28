package fhtml.attributes

import fhtml.*

class Colspan(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"colspan=\"$suffix\""
	def getSuffix:               String = suffix

object Colspan:
	def apply(): Colspan = new Colspan(false)
	def w(): Colspan = new Colspan(true)

	def :-(suffixValue: String): Colspan = 
		var ret = new Colspan(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Colspan = 
		var ret = new Colspan(true)
		ret.suffix = suffixValue
		ret