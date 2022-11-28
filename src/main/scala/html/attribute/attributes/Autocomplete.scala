package fhtml.attributes

import fhtml.*

class Autocomplete(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("form", "input")
	val browserSupport: AttributeSupport = 
		AttributeSupport(
			scala.collection.immutable.Map(
				"form" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("4.0"),
					Opera(  "15.0"),
					Safari( "5.2")
				),
				"input" -> (
					Chrome( "17.0"),
					Edge(   "5.0"),
					Firefox("4.0"),
					Opera(  "9.6"),
					Safari( "15.0")
				)
			)
		)

	def getAttribute:            String = s"autocomplete=\"$suffix\""
	def getSuffix:               String = suffix

object Autocomplete:
	def apply(): Autocomplete = new Autocomplete(false)
	def w(): Autocomplete = new Autocomplete(true)

	def :-(suffixValue: String): Autocomplete = 
		var ret = new Autocomplete(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Autocomplete = 
		var ret = new Autocomplete(true)
		ret.suffix = suffixValue
		ret