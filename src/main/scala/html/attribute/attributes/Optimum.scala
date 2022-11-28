package fhtml.attributes

import fhtml.*

class Optimum(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("meter")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"meter" -> (
					Chrome( "8.0"),
					Edge(   ""),
					Firefox("6.0"),
					Opera(  "11.0"),
					Safari( "6.0")
				)
			)
		)

	def getAttribute:            String = s"optimum=\"$suffix\""
	def getSuffix:               String = suffix

object Optimum:
	def apply(): Optimum = new Optimum(false)
	def w(): Optimum = new Optimum(true)

	def :-(suffixValue: String): Optimum = 
		var ret = new Optimum(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Optimum = 
		var ret = new Optimum(true)
		ret.suffix = suffixValue
		ret