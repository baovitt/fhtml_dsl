package fhtml.attributes

import fhtml.*

class Maxlength(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"input" -> (
					Chrome( "1.0"),
					Edge(   "2.0"),
					Firefox("1.0"),
					Opera(  "1.0"),
					Safari( "1.0")
				),
				"textarea" -> (
					Chrome( "All"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "15.0"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"maxlength=\"$suffix\""
	def getSuffix:               String = suffix

object Maxlength:
	def apply(): Maxlength = new Maxlength(false)
	def w(): Maxlength = new Maxlength(true)

	def :-(suffixValue: String): Maxlength = 
		var ret = new Maxlength(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Maxlength = 
		var ret = new Maxlength(true)
		ret.suffix = suffixValue
		ret