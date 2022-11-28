package fhtml.attributes

import fhtml.*

class Checked(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("input")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"input" -> (
					Chrome( "1.0"),
					Edge(   "2.0"),
					Firefox("1.0"),
					Opera(  "1.0"),
					Safari( "1.0")
				)
			)
		)

	def getAttribute: String = "checked"

object Checked:
	def apply(): Checked = new Checked(false)
	def w: Checked = new Checked(true)