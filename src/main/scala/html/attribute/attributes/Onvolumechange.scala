package fhtml.attributes

import fhtml.*

class Onvolumechange(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onvolumechange=\"$suffix\""
	def getSuffix:               String = suffix

object Onvolumechange:
	def apply(): Onvolumechange = new Onvolumechange(false)
	def w(): Onvolumechange = new Onvolumechange(true)

	def :-(suffixValue: String): Onvolumechange = 
		var ret = new Onvolumechange(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onvolumechange = 
		var ret = new Onvolumechange(true)
		ret.suffix = suffixValue
		ret