package fhtml.attributes

import fhtml.*

class Onmouseover(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onmouseover=\"$suffix\""
	def getSuffix:               String = suffix 

object Onmouseover:
	def apply(): Onmouseover = new Onmouseover(false)
	def w(): Onmouseover = new Onmouseover(true)

	def :-(suffixValue: String): Onmouseover = 
		var ret = new Onmouseover(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onmouseover = 
		var ret = new Onmouseover(true)
		ret.suffix = suffixValue
		ret