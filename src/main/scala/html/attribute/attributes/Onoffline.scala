package fhtml.attributes

import fhtml.*

class Onoffline(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"All visible elements" -> (
					Chrome( ""),
					Edge(   "8.0"),
					Firefox("3.0"),
					Opera(  ""),
					Safari( "")
				)
			)
		)

	def getAttribute:            String = s"onoffline=\"$suffix\""
	def getSuffix:               String = suffix 

object Onoffline:
	def apply(): Onoffline = new Onoffline(false)
	def w(): Onoffline = new Onoffline(true)

	def :-(suffixValue: String): Onoffline = 
		var ret = new Onoffline(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onoffline = 
		var ret = new Onoffline(true)
		ret.suffix = suffixValue
		ret