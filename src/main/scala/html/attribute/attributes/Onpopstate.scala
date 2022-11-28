package fhtml.attributes

import fhtml.*

class Onpopstate(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
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

	def getAttribute:            String = s"onpopstate=\"$suffix\""
	def getSuffix:               String = suffix 

object Onpopstate:
	def apply(): Onpopstate = new Onpopstate(false)
	def w(): Onpopstate = new Onpopstate(true)

	def :-(suffixValue: String): Onpopstate = 
		var ret = new Onpopstate(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onpopstate = 
		var ret = new Onpopstate(true)
		ret.suffix = suffixValue
		ret