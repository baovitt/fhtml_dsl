package fhtml.attributes

import fhtml.*

class Selected(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("option")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"option" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute: String = "selected"

object Selected:
	def apply(): Selected = new Selected(false)
	def w: Selected = new Selected(true)