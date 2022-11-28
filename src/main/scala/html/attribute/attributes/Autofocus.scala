package fhtml.attributes

import fhtml.*

class Autofocus(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("form", "input", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"form" -> (
					Chrome( "5.0"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "9.6"),
					Safari( "5.0")
				),
				"input" -> (
					Chrome( "5.0"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "9.6"),
					Safari( "5.0")
				),
				"textarea" -> (
					Chrome( "All"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute: String = "autofocus"

object Autofocus:
	def apply(): Autofocus = new Autofocus(false)
	def w: Autofocus = new Autofocus(true)