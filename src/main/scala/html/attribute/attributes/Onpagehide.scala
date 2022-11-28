package fhtml.attributes

import fhtml.*

class Onpagehide(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"body" -> (
					Chrome( "Unknown"),
					Edge(   "Unknown"),
					Firefox("Unknown"),
					Opera(  "Unknown"),
					Safari( "Unknown")
				)
			)
		)

	def getAttribute:            String = s"onpagehide=\"$suffix\""
	def getSuffix:               String = suffix

object Onpagehide:
	def apply(): Onpagehide = new Onpagehide(false)
	def w(): Onpagehide = new Onpagehide(true)

	def :-(suffixValue: String): Onpagehide = 
		var ret = new Onpagehide(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onpagehide = 
		var ret = new Onpagehide(true)
		ret.suffix = suffixValue
		ret