package fhtml.attributes

import fhtml.*

class Ondrop(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"All visible elements" -> (
					Chrome( "4.0"),
					Edge(   "9.0"),
					Firefox("3.5"),
					Opera(  "12.0"),
					Safari( "6.0")
				)
			)
		)

	def getAttribute:            String = s"ondrop=\"$suffix\""
	def getSuffix:               String = suffix

object Ondrop:
	def apply(): Ondrop = new Ondrop(false)
	def w(): Ondrop = new Ondrop(true)

	def :-(suffixValue: String): Ondrop = 
		var ret = new Ondrop(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Ondrop = 
		var ret = new Ondrop(true)
		ret.suffix = suffixValue
		ret