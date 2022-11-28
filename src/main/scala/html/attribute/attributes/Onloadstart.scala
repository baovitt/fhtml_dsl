package fhtml.attributes

import fhtml.*

class Onloadstart(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onloadstart=\"$suffix\""
	def getSuffix:               String = suffix 

object Onloadstart:
	def apply(): Onloadstart = new Onloadstart(false)
	def w(): Onloadstart = new Onloadstart(true)

	def :-(suffixValue: String): Onloadstart = 
		var ret = new Onloadstart(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onloadstart = 
		var ret = new Onloadstart(true)
		ret.suffix = suffixValue
		ret