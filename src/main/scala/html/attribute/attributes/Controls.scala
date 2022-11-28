package fhtml.attributes

import fhtml.*

class Controls(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"audio" -> (
					Chrome( "4.0"),
					Edge(   "9.0"),
					Firefox("3.5"),
					Opera(  "10.5"),
					Safari( "4.0")
				),
				"video" -> (
					Chrome( "4.0"),
					Edge(   "9.0"),
					Firefox("3.5"),
					Opera(  "10.5"),
					Safari( "4.0")
				)
			)
		)

	def getAttribute: String = "controls"

object Controls:
	def apply(): Controls = new Controls(false)
	def w: Controls = new Controls(true)