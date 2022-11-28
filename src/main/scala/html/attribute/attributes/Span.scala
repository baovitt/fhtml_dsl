package fhtml.attributes

import fhtml.*

class Span(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("col", "colgroup")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"col" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"colgroup" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"span=\"$suffix\""
	def getSuffix:               String = suffix

object Span:
	def apply(): Span = new Span(false)
	def w(): Span = new Span(true)

	def :-(suffixValue: String): Span = 
		var ret = new Span(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Span = 
		var ret = new Span(true)
		ret.suffix = suffixValue
		ret