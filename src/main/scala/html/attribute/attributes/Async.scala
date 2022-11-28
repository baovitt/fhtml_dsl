package fhtml.attributes

import fhtml.*

class Async(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("script")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map (
				"script" -> (
					Chrome( "All"),
					Edge(   "10.0"),
					Firefox("3.6"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute: String = "async"

object Async:
	def apply(): Async = new Async(false)
	def w: Async = new Async(true)