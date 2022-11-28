package fhtml.attributes

import fhtml.*

class Oninvalidate(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"All visible elements" -> (
					Chrome( "All"),
					Edge(   "10.0"),
					Firefox("All"),
					Opera(  ""),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"oninvalidate=\"$suffix\""
	def getSuffix:               String = suffix 

object Oninvalidate:
	def apply(): Oninvalidate = new Oninvalidate(false)
	def w(): Oninvalidate = new Oninvalidate(true)

	def :-(suffixValue: String): Oninvalidate = 
		var ret = new Oninvalidate(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Oninvalidate = 
		var ret = new Oninvalidate(true)
		ret.suffix = suffixValue
		ret