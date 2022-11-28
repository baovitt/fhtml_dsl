package fhtml.attributes

import fhtml.*

class Onratechange(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onratechange=\"$suffix\""
	def getSuffix:               String = suffix

object Onratechange:
	def apply(): Onratechange = new Onratechange(false)
	def w(): Onratechange = new Onratechange(true)

	def :-(suffixValue: String): Onratechange = 
		var ret = new Onratechange(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onratechange = 
		var ret = new Onratechange(true)
		ret.suffix = suffixValue
		ret