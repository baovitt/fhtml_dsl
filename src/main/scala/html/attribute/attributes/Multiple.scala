package fhtml.attributes

import fhtml.*

class Multiple(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "select")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"input" -> (
					Chrome( "6.0"),
					Edge(   "10.0"),
					Firefox("3.6"),
					Opera(  "11.0"),
					Safari( "5.0")
				),
				"select" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"multiple=\"$suffix\""
	def getSuffix:               String = suffix

object Multiple:
	def apply(): Multiple = new Multiple(false)
	def w(): Multiple = new Multiple(true)

	def :-(suffixValue: String): Multiple = 
		var ret = new Multiple(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Multiple = 
		var ret = new Multiple(true)
		ret.suffix = suffixValue
		ret