package fhtml.attributes

import fhtml.*

class Poster(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"video" -> (
					Chrome( "4.0"),
					Edge(   "9.0"),
					Firefox("3.5"),
					Opera(  "10.5"),
					Safari( "4.0")
				)
			)
		)

	def getAttribute:            String = s"poster=\"$suffix\""
	def getSuffix:               String = suffix

object Poster:
	def apply(): Poster = new Poster(false)
	def w(): Poster = new Poster(true)

	def :-(suffixValue: String): Poster = 
		var ret = new Poster(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Poster = 
		var ret = new Poster(true)
		ret.suffix = suffixValue
		ret