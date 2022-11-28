package fhtml.attributes

import fhtml.*

class Reversed(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("ol")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"ol" -> (
					Chrome( "18.0"),
					Edge(   ""),
					Firefox("18.0"),
					Opera(  "All"),
					Safari( "5.2")
				)
			)
		)

	def getAttribute: String = "reversed"

object Reversed:
	def apply(): Reversed = new Reversed(false)
	def w: Reversed = new Reversed(true)