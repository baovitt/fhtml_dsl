package fhtml.attributes

import fhtml.*

class Novalidate(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"video" -> (
					Chrome( "10.0"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "10.6"),
					Safari( "")
				)
			)
		)

	def getAttribute: String = "novalidate"

object Novalidate:
	def apply(): Novalidate = new Novalidate(false)
	def w: Novalidate = new Novalidate(true)