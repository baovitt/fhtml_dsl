package fhtml.attributes

import fhtml.*

class Hreflang(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("a", "area", "link")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"a" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"area" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"link" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"hreflang=\"$suffix\""
	def getSuffix:               String = suffix

object Hreflang:
	def apply(): Hreflang = new Hreflang(false)
	def w(): Hreflang = new Hreflang(true)

	def :-(suffixValue: String): Hreflang = 
		var ret = new Hreflang(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Hreflang = 
		var ret = new Hreflang(true)
		ret.suffix = suffixValue
		ret