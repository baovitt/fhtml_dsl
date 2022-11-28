package fhtml.attributes

import fhtml.*

class Onended(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onended=\"$suffix\""
	def getSuffix:               String = suffix

object Onended:
	def apply(): Onended = new Onended(false)
	def w(): Onended = new Onended(true)

	def :-(suffixValue: String): Onended = 
		var ret = new Onended(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onended = 
		var ret = new Onended(true)
		ret.suffix = suffixValue
		ret