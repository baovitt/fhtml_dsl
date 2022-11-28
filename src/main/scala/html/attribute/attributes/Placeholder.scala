package fhtml.attributes

import fhtml.*

class Placeholder(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"input" -> (
					Chrome( "10.0"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "11.0"),
					Safari( "5.0")
				),
				"input" -> (
					Chrome( "All"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "11.5"),
					Safari( "5.0")
				)
			)
		)

	def getAttribute:            String = s"placeholder=\"$suffix\""
	def getSuffix:               String = suffix

object Placeholder:
	def apply(): Placeholder = new Placeholder(false)
	def w(): Placeholder = new Placeholder(true)

	def :-(suffixValue: String): Placeholder = 
		var ret = new Placeholder(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Placeholder = 
		var ret = new Placeholder(true)
		ret.suffix = suffixValue
		ret