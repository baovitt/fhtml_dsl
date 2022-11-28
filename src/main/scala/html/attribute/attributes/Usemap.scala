package fhtml.attributes

import fhtml.*

class Usemap(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("img", "object")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"img" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"object" -> (
					Chrome( ""),
					Edge(   "All"),
					Firefox("All"),
					Opera(  ""),
					Safari( "")
				)
			)
		)

	def getAttribute:            String = s"usemap=\"$suffix\""
	def getSuffix:               String = suffix

object Usemap:
	def apply(): Usemap = new Usemap(false)
	def w(): Usemap = new Usemap(true)

	def :-(suffixValue: String): Usemap = 
		var ret = new Usemap(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Usemap = 
		var ret = new Usemap(true)
		ret.suffix = suffixValue
		ret