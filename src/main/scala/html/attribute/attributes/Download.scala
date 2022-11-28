package fhtml.attributes

import fhtml.*

class Download(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("a", "area")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"a" -> (
					Chrome( "14.0"),
					Edge(   "13.0"),
					Firefox("20.0"),
					Opera(  "15.0"),
					Safari( "")
				),
				"area" -> (
					Chrome( "14.0"),
					Edge(   ""),
					Firefox("20.0"),
					Opera(  "15.0"),
					Safari( "")
				)
			)
		)

	def getAttribute: String = "download"
	
object Download:
	def apply(): Download = new Download(false)
	def w: Download = new Download(true)