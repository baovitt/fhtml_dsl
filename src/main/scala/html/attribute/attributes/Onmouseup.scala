package fhtml.attributes

import fhtml.*

class Onmouseup(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onmouseup=\"$suffix\""
	def getSuffix:               String = suffix 

object Onmouseup:
	def apply(): Onmouseup = new Onmouseup(false)
	def w(): Onmouseup = new Onmouseup(true)

	def :-(suffixValue: String): Onmouseup = 
		var ret = new Onmouseup(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onmouseup = 
		var ret = new Onmouseup(true)
		ret.suffix = suffixValue
		ret