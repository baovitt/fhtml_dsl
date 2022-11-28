package fhtml.attributes

import fhtml.*

class Preload(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"audio" -> (
					Chrome( "4.0"),
					Edge(   "9.0"),
					Firefox("4.0"),
					Opera(  "10.5"),
					Safari( "4.0")
				),
				"video" -> (
					Chrome( "4.0"),
					Edge(   ""),
					Firefox("4.0"),
					Opera(  "10.5"),
					Safari( "4.0")
				)
			)
		)

	def getAttribute:            String = s"preload=\"$suffix\""
	def getSuffix:               String = suffix

object Preload:
	def apply(): Preload = new Preload(false)
	def w(): Preload = new Preload(true)

	def :-(suffixValue: String): Preload = 
		var ret = new Preload(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Preload = 
		var ret = new Preload(true)
		ret.suffix = suffixValue
		ret