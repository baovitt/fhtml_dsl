package fhtml.attributes

import fhtml.*

class Onmouseout(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onmouseout=\"$suffix\""
	def getSuffix:               String = suffix 

object Onmouseout:
	def apply(): Onmouseout = new Onmouseout(false)
	def w(): Onmouseout = new Onmouseout(true)

	def :-(suffixValue: String): Onmouseout = 
		var ret = new Onmouseout(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onmouseout = 
		var ret = new Onmouseout(true)
		ret.suffix = suffixValue
		ret