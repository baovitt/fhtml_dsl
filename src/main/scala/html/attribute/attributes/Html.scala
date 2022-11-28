package fhtml.attributes

import fhtml.*

class Html(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("doctype")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map (
				"doctype" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute: String = "html"

object Html:
	def apply(): Html = new Html(false)
	def w: Html = new Html(true)