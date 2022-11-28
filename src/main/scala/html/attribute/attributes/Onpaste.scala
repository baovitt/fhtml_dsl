package fhtml.attributes

import fhtml.*

class Onpaste(showWarning: Boolean) extends ParamAttribute(showWarning):
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
	
	def getAttribute:            String = s"onpaste=\"$suffix\""
	def getSuffix:               String = suffix 

object Onpaste:
	def apply(): Onpaste = new Onpaste(false)
	def w(): Onpaste = new Onpaste(true)

	def :-(suffixValue: String): Onpaste = 
		var ret = new Onpaste(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onpaste = 
		var ret = new Onpaste(true)
		ret.suffix = suffixValue
		ret