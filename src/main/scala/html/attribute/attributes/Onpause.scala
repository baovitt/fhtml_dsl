package fhtml.attributes

import fhtml.*

class Onpause(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onpause=\"$suffix\""
	def getSuffix:               String = suffix 

object Onpause:
	def apply(): Onpause = new Onpause(false)
	def w(): Onpause = new Onpause(true)

	def :-(suffixValue: String): Onpause = 
		var ret = new Onpause(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onpause = 
		var ret = new Onpause(true)
		ret.suffix = suffixValue
		ret