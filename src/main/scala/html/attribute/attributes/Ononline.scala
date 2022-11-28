package fhtml.attributes

import fhtml.*

class Ononline(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"ononline=\"$suffix\""
	def getSuffix:               String = suffix 

object Ononline:
	def apply(): Ononline = new Ononline(false)
	def w(): Ononline = new Ononline(true)

	def :-(suffixValue: String): Ononline = 
		var ret = new Ononline(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Ononline = 
		var ret = new Ononline(true)
		ret.suffix = suffixValue
		ret