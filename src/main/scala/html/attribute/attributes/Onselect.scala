package fhtml.attributes

import fhtml.*

class Onselect(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onselect=\"$suffix\""
	def getSuffix:               String = suffix

object Onselect:
	def apply(): Onselect = new Onselect(false)
	def w(): Onselect = new Onselect(true)

	def :-(suffixValue: String): Onselect = 
		var ret = new Onselect(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onselect = 
		var ret = new Onselect(true)
		ret.suffix = suffixValue
		ret