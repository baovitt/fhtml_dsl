package fhtml.attributes

import fhtml.*

class Muted(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"video" -> (
					Chrome( "4.0"),
					Edge(   "10.0"),
					Firefox("11.0"),
					Opera(  "10.5"),
					Safari( "7.1")
				)
			)
		)

	def getAttribute: String = "muted"

object Muted:
	def apply(): Muted = new Muted(false)
	def w: Muted = new Muted(true)