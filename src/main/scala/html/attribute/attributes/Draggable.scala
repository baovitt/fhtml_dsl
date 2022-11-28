package fhtml.attributes

import fhtml.*

class Draggable(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"Global Attribute" -> (
					Chrome( "4.0"),
					Edge(   "9.0"),
					Firefox("3.5"),
					Opera(  "13.0"),
					Safari( "6.0")
				)
			)
		)

	def getAttribute:            String = "draggabe"

object Draggable:
	def apply(): Draggable = new Draggable(false)
	def w: Draggable = new Draggable(true)