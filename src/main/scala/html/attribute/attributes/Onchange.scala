package fhtml.attributes

import fhtml.*

class Onchange(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onchange=\"$suffix\""
	def getSuffix:               String = suffix

object Onchange:
	def apply(): Onchange = new Onchange(false)
	def w(): Onchange = new Onchange(true)

	def :-(suffixValue: String): Onchange = 
		var ret = new Onchange(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onchange = 
		var ret = new Onchange(true)
		ret.suffix = suffixValue
		ret