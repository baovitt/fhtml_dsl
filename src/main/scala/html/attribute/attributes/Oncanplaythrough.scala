package fhtml.attributes

import fhtml.*

class Oncanplaythrough(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"oncanplaythrough=\"$suffix\""
	def getSuffix:               String = suffix

object Oncanplaythrough:
	def apply(): Oncanplaythrough = new Oncanplaythrough(false)
	def w(): Oncanplaythrough = new Oncanplaythrough(true)

	def :-(suffixValue: String): Oncanplaythrough = 
		var ret = new Oncanplaythrough(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Oncanplaythrough = 
		var ret = new Oncanplaythrough(true)
		ret.suffix = suffixValue
		ret