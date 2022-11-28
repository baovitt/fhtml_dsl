package fhtml.attributes

import fhtml.*

class Oninput(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"oninput=\"$suffix\""
	def getSuffix:               String = suffix 

object Oninput:
	def apply(): Oninput = new Oninput(false)
	def w(): Oninput = new Oninput(true)

	def :-(suffixValue: String): Oninput = 
		var ret = new Oninput(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Oninput = 
		var ret = new Oninput(true)
		ret.suffix = suffixValue
		ret