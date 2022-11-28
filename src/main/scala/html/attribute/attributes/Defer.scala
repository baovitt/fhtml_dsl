package fhtml.attributes

import fhtml.*

class Defer(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("script")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"script" -> (
					Chrome( "All"),
					Edge(   "10.0"),
					Firefox("3.6"),
					Opera(  "15.0"),
					Safari( "All")
				)
			)
		)

	def getAttribute: String = "defer"

object Defer:
	def apply(): Defer = new Defer(false)
	def w: Defer = new Defer(true)