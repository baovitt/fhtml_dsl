package fhtml.attributes

import fhtml.*

class Contenteditable(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"Global Attributes" -> (
					Chrome( "4.0"),
					Edge(   "6.0"),
					Firefox("3.5"),
					Opera(  "10.1"),
					Safari( "3.1")
				)
			)
		)

	def getAttribute: String = "contenteditable"

object Contenteditable:
	def apply(): Contenteditable = new Contenteditable(false)
	def w: Contenteditable = new Contenteditable(true)