package fhtml.attributes

import fhtml.*

class Onloadeddata(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"audio" -> (
					Chrome( "All"),
					Edge(   "9.0"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"video" -> (
					Chrome( "All"),
					Edge(   "9.0"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"onloadeddata=\"$suffix\""
	def getSuffix:               String = suffix 

object Onloadeddata:
	def apply(): Onloadeddata = new Onloadeddata(false)
	def w(): Onloadeddata = new Onloadeddata(true)

	def :-(suffixValue: String): Onloadeddata = 
		var ret = new Onloadeddata(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onloadeddata = 
		var ret = new Onloadeddata(true)
		ret.suffix = suffixValue
		ret