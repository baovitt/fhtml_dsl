package fhtml.attributes

import fhtml.*

class Coords(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"coords=\"$suffix\""
	def getSuffix:               String = suffix

object Coords:
	def apply(): Coords = new Coords(false)
	def w(): Coords = new Coords(true)

	def :-(suffixValue: String): Coords = 
		var ret = new Coords(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Coords = 
		var ret = new Coords(true)
		ret.suffix = suffixValue
		ret