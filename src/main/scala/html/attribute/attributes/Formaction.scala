package fhtml.attributes

import fhtml.*

class Formaction(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("button", "input")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"button" -> (
					Chrome( "9.0"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "10.6"),
					Safari( "5.1")
				),
				"input" -> (
					Chrome( "9.0"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "10.6"),
					Safari( "5.1")
				)
			)
		)

	def getAttribute:            String = s"formaction=\"$suffix\""
	def getSuffix:               String = suffix

object Formaction:
	def apply(): Formaction = new Formaction(false)
	def w(): Formaction = new Formaction(true)

	def :-(suffixValue: String): Formaction = 
		var ret = new Formaction(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Formaction = 
		var ret = new Formaction(true)
		ret.suffix = suffixValue
		ret