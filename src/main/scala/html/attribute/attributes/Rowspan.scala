package fhtml.attributes

import fhtml.*

class Rowspan(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"rowspan=\"$suffix\""
	def getSuffix:               String = suffix

object Rowspan:
	def apply(): Rowspan = new Rowspan(false)
	def w(): Rowspan = new Rowspan(true)

	def :-(suffixValue: String): Rowspan = 
		var ret = new Rowspan(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Rowspan = 
		var ret = new Rowspan(true)
		ret.suffix = suffixValue
		ret