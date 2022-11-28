package fhtml.attributes

import fhtml.*

class Onkeypress(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onkeypress=\"$suffix\""
	def getSuffix:               String = suffix 

object Onkeypress:
	def apply(): Onkeypress = new Onkeypress(false)
	def w(): Onkeypress = new Onkeypress(true)

	def :-(suffixValue: String): Onkeypress = 
		var ret = new Onkeypress(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onkeypress = 
		var ret = new Onkeypress(true)
		ret.suffix = suffixValue
		ret