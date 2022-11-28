package fhtml.attributes

import fhtml.*

class Onloadedmetadata(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onloadedmetadata=\"$suffix\""
	def getSuffix:               String = suffix 

object Onloadedmetadata:
	def apply(): Onloadedmetadata = new Onloadedmetadata(false)
	def w(): Onloadedmetadata = new Onloadedmetadata(true)

	def :-(suffixValue: String): Onloadedmetadata = 
		var ret = new Onloadedmetadata(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onloadedmetadata = 
		var ret = new Onloadedmetadata(true)
		ret.suffix = suffixValue
		ret