package fhtml.attributes

import fhtml.*

class Onemptied(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"audio" -> (
					Chrome( "Unknown"),
					Edge(   "Unknown"),
					Firefox("Unknown"),
					Opera(  "Unknown"),
					Safari( "Unknown")
				),
				"video" -> (
					Chrome( "Unknown"),
					Edge(   "Unknown"),
					Firefox("Unknown"),
					Opera(  "Unknown"),
					Safari( "Unknown")
				)
			)
		)
	
	def getAttribute:            String = s"onemptied=\"$suffix\""
	def getSuffix:               String = suffix

object Onemptied:
	def apply(): Onemptied = new Onemptied(false)
	def w(): Onemptied = new Onemptied(true)

	def :-(suffixValue: String): Onemptied = 
		var ret = new Onemptied(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onemptied = 
		var ret = new Onemptied(true)
		ret.suffix = suffixValue
		ret