package fhtml.attributes

import fhtml.*

class Readonly(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("input", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"input" -> (
					Chrome( "1.0"),
					Edge(   "6.0"),
					Firefox("1.0"),
					Opera(  "1.0"),
					Safari( "1.0")
				),
				"video" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute: String = "readonly"

object Readonly:
	def apply(): Readonly = new Readonly(false)
	def w: Readonly = new Readonly(true)