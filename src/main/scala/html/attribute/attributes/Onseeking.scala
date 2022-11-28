package fhtml.attributes

import fhtml.*

class Onseeking(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onseeking=\"$suffix\""
	def getSuffix:               String = suffix

object Onseeking:
	def apply(): Onseeking = new Onseeking(false)
	def w(): Onseeking = new Onseeking(true)

	def :-(suffixValue: String): Onseeking = 
		var ret = new Onseeking(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onseeking = 
		var ret = new Onseeking(true)
		ret.suffix = suffixValue
		ret