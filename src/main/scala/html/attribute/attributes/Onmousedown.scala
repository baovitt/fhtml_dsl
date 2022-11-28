package fhtml.attributes

import fhtml.*

class Onmousedown(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onmousedown=\"$suffix\""
	def getSuffix:               String = suffix 

object Onmousedown:
	def apply(): Onmousedown = new Onmousedown(false)
	def w(): Onmousedown = new Onmousedown(true)

	def :-(suffixValue: String): Onmousedown = 
		var ret = new Onmousedown(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onmousedown = 
		var ret = new Onmousedown(true)
		ret.suffix = suffixValue
		ret