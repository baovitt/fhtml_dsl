package fhtml.attributes

import fhtml.*

class Translate(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"Global Attributes" -> (
					Chrome( ""),
					Edge(   ""),
					Firefox(""),
					Opera(  ""),
					Safari( "")
				)
			)
		)

	def getAttribute:            String = s"translate=\"$suffix\""
	def getSuffix:               String = suffix

object Translate:
	def apply(): Translate = new Translate(false)
	def w(): Translate = new Translate(true)

	def :-(suffixValue: String): Translate = 
		var ret = new Translate(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Translate = 
		var ret = new Translate(true)
		ret.suffix = suffixValue
		ret