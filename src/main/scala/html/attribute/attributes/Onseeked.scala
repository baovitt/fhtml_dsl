package fhtml.attributes

import fhtml.*

class Onseeked(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onseeked=\"$suffix\""
	def getSuffix:               String = suffix

object Onseeked:
	def apply(): Onseeked = new Onseeked(false)
	def w(): Onseeked = new Onseeked(true)

	def :-(suffixValue: String): Onseeked = 
		var ret = new Onseeked(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onseeked = 
		var ret = new Onseeked(true)
		ret.suffix = suffixValue
		ret