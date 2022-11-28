package fhtml.attributes

import fhtml.*

class Ontimeupdate(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"ontimeupdate=\"$suffix\""
	def getSuffix:               String = suffix

object Ontimeupdate:
	def apply(): Ontimeupdate = new Ontimeupdate(false)
	def w(): Ontimeupdate = new Ontimeupdate(true)

	def :-(suffixValue: String): Ontimeupdate = 
		var ret = new Ontimeupdate(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Ontimeupdate = 
		var ret = new Ontimeupdate(true)
		ret.suffix = suffixValue
		ret