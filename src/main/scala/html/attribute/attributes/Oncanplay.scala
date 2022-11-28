package fhtml.attributes

import fhtml.*

class Oncanplay(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "embed", "object", "video")
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
				"embed" -> (
					Chrome( ""),
					Edge(   ""),
					Firefox(""),
					Opera(  ""),
					Safari( "")
				),
				"object" -> (
					Chrome( ""),
					Edge(   ""),
					Firefox(""),
					Opera(  ""),
					Safari( "")
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

	def getAttribute:            String = s"oncanplay=\"$suffix\""
	def getSuffix:               String = suffix

object Oncanplay:
	def apply(): Oncanplay = new Oncanplay(false)
	def w(): Oncanplay = new Oncanplay(true)

	def :-(suffixValue: String): Oncanplay = 
		var ret = new Oncanplay(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Oncanplay = 
		var ret = new Oncanplay(true)
		ret.suffix = suffixValue
		ret