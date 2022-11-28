package fhtml.attributes

import fhtml.*

class Onfocus(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"All visible elements" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"onfocus=\"$suffix\""
	def getSuffix:               String = suffix

object Onfocus:
	def apply(): Onfocus = new Onfocus(false)
	def w(): Onfocus = new Onfocus(true)

	def :-(suffixValue: String): Onfocus = 
		var ret = new Onfocus(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onfocus = 
		var ret = new Onfocus(true)
		ret.suffix = suffixValue
		ret