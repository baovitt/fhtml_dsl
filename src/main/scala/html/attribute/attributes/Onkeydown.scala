package fhtml.attributes

import fhtml.*

class Onkeydown(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onkeydown=\"$suffix\""
	def getSuffix:               String = suffix 

object Onkeydown:
	def apply(): Onkeydown = new Onkeydown(false)
	def w(): Onkeydown = new Onkeydown(true)

	def :-(suffixValue: String): Onkeydown = 
		var ret = new Onkeydown(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onkeydown = 
		var ret = new Onkeydown(true)
		ret.suffix = suffixValue
		ret