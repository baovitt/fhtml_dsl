package fhtml.attributes

import fhtml.*

class Ondurationchange(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"ondurationchange=\"$suffix\""
	def getSuffix:               String = suffix

object Ondurationchange:
	def apply(): Ondurationchange = new Ondurationchange(false)
	def w(): Ondurationchange = new Ondurationchange(true)

	def :-(suffixValue: String): Ondurationchange = 
		var ret = new Ondurationchange(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Ondurationchange = 
		var ret = new Ondurationchange(true)
		ret.suffix = suffixValue
		ret