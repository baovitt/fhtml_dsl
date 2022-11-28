package fhtml.attributes

import fhtml.*

class Onhashchange(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"All visible elements" -> (
					Chrome( "5.0"),
					Edge(   "8.0"),
					Firefox("3.6"),
					Opera(  "10.6"),
					Safari( "5.0")
				)
			)
		)

	def getAttribute:            String = s"onhashchange=\"$suffix\""
	def getSuffix:               String = suffix

object Onhashchange:
	def apply(): Onhashchange = new Onhashchange(false)
	def w(): Onhashchange = new Onhashchange(true)

	def :-(suffixValue: String): Onhashchange = 
		var ret = new Onhashchange(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onhashchange = 
		var ret = new Onhashchange(true)
		ret.suffix = suffixValue
		ret