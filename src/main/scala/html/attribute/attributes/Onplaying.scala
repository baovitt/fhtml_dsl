package fhtml.attributes

import fhtml.*

class Onplaying(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onplaying=\"$suffix\""
	def getSuffix:               String = suffix 

object Onplaying:
	def apply(): Onplaying = new Onplaying(false)
	def w(): Onplaying = new Onplaying(true)

	def :-(suffixValue: String): Onplaying = 
		var ret = new Onplaying(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onplaying = 
		var ret = new Onplaying(true)
		ret.suffix = suffixValue
		ret