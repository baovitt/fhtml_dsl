package fhtml.attributes

import fhtml.*

class Kind(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("track")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"Global Attribute" -> (
					Chrome( "18.0"),
					Edge(   "10.0"),
					Firefox("31.0"),
					Opera(  "15.0"),
					Safari( "6.0")
				)
			)
		)

	def getAttribute:            String = s"kind=\"$suffix\""
	def getSuffix:               String = suffix

object Kind:
	def apply(): Kind = new Kind(false)
	def w(): Kind = new Kind(true)

	def :-(suffixValue: String): Kind = 
		var ret = new Kind(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Kind = 
		var ret = new Kind(true)
		ret.suffix = suffixValue
		ret