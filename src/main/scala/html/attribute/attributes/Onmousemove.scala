package fhtml.attributes

import fhtml.*

class Onmousemove(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onmousemove=\"$suffix\""
	def getSuffix:               String = suffix 

object Onmousemove:
	def apply(): Onmousemove = new Onmousemove(false)
	def w(): Onmousemove = new Onmousemove(true)

	def :-(suffixValue: String): Onmousemove = 
		var ret = new Onmousemove(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onmousemove = 
		var ret = new Onmousemove(true)
		ret.suffix = suffixValue
		ret