package fhtml.attributes

import fhtml.*

class Loop(showWarning: Boolean) extends NoParamAttribute(showWarning):
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
					Firefox("11.0"),
					Opera(  "10.5"),
					Safari( "4.0")
				)
			)
		)

	def getAttribute: String = "loop"

object Loop:
	def apply(): Loop = new Loop(false)
	def w: Loop = new Loop(true)