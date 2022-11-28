package fhtml.attributes

import fhtml.*

class Onsuspend(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onsuspend=\"$suffix\""
	def getSuffix:               String = suffix

object Onsuspend:
	def apply(): Onsuspend = new Onsuspend(false)
	def w(): Onsuspend = new Onsuspend(true)

	def :-(suffixValue: String): Onsuspend = 
		var ret = new Onsuspend(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onsuspend = 
		var ret = new Onsuspend(true)
		ret.suffix = suffixValue
		ret