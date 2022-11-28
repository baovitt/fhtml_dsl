package fhtml.attributes

import fhtml.*

class Rel(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("a", "area", "form", "link")
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
				"form" -> (
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

	def getAttribute:            String = s"rel=\"$suffix\""
	def getSuffix:               String = suffix

object Rel:
	def apply(): Rel = new Rel(false)
	def w(): Rel = new Rel(true)

	def :-(suffixValue: String): Rel = 
		var ret = new Rel(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Rel = 
		var ret = new Rel(true)
		ret.suffix = suffixValue
		ret