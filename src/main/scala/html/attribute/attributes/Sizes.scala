package fhtml.attributes

import fhtml.*

class Sizes(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("link")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"link" -> (
					Chrome( ""),
					Edge(   ""),
					Firefox(""),
					Opera(  ""),
					Safari( "")
				)
			)
		)

	def getAttribute:            String = s"sizes=\"$suffix\""
	def getSuffix:               String = suffix

object Sizes:
	def apply(): Sizes = new Sizes(false)
	def w(): Sizes = new Sizes(true)

	def :-(suffixValue: String): Sizes = 
		var ret = new Sizes(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Sizes = 
		var ret = new Sizes(true)
		ret.suffix = suffixValue
		ret