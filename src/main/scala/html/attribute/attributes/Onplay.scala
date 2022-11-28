package fhtml.attributes

import fhtml.*

class Onplay(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onplay=\"$suffix\""
	def getSuffix:               String = suffix 

object Onplay:
	def apply(): Onplay = new Onplay(false)
	def w(): Onplay = new Onplay(true)

	def :-(suffixValue: String): Onplay = 
		var ret = new Onplay(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onplay = 
		var ret = new Onplay(true)
		ret.suffix = suffixValue
		ret