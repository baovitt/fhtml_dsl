package fhtml.attributes

import fhtml.*

class Sandbox(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("iframe")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"iframe" -> (
					Chrome( "4.0"),
					Edge(   "10.0"),
					Firefox("17.0"),
					Opera(  "15.0"),
					Safari( "5.0")
				)
			)
		)

	def getAttribute: String = "sandbox"

object Sandbox:
	def apply(): Sandbox = new Sandbox(false)
	def w: Sandbox = new Sandbox(true)