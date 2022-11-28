package fhtml.attributes

import fhtml.*

class Open(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("details")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"details" -> (
					Chrome( "12.0"),
					Edge(   ""),
					Firefox(""),
					Opera(  "15.0"),
					Safari( "6.0")
				)
			)
		)

	def getAttribute:            String = "open"
	def this() = this(DefaultWarningValue)

object Open:
	def apply(): Open = new Open(false)
	def w: Open = new Open(true)