package fhtml.attributes

import fhtml.*

class Href(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("a", "area", "base", "link")
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
				"base" -> (
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

	def getAttribute:            String = s"href=\"$suffix\""
	def getSuffix:               String = suffix

object Href:
	def apply(): Href = new Href(false)
	def w(): Href = new Href(true)

	def :-(suffixValue: String): Href = 
		var ret = new Href(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Href = 
		var ret = new Href(true)
		ret.suffix = suffixValue
		ret