package fhtml.attributes

import fhtml.*

class Required(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("a", "area", "form", "link")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"input" -> (
					Chrome( "5.0"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "9.6"),
					Safari( "")
				),
				"select" -> (
					Chrome( "All"),
					Edge(   "10.0"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "")
				),
				"textarea" -> (
					Chrome( "5.0"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "All"),
					Safari( "")
				)
			)
		)

	def getAttribute: String = "required"

object Required:
	def apply(): Required = new Required(false)
	def w: Required = new Required(true)