package fhtml.attributes

import fhtml.*

class Autoplay(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map (
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

	def getAttribute: String = "autoplay"

object Autoplay:
	def apply(): Autoplay = new Autoplay(false)
	def w: Autoplay = new Autoplay(true)