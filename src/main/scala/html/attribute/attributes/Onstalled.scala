package fhtml.attributes

import fhtml.*

class Onstalled(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onstalled=\"$suffix\""
	def getSuffix:               String = suffix

object Onstalled:
	def apply(): Onstalled = new Onstalled(false)
	def w(): Onstalled = new Onstalled(true)

	def :-(suffixValue: String): Onstalled = 
		var ret = new Onstalled(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onstalled = 
		var ret = new Onstalled(true)
		ret.suffix = suffixValue
		ret