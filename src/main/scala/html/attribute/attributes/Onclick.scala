package fhtml.attributes

import fhtml.*

class Onclick(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onclick=\"$suffix\""
	def getSuffix:               String = suffix

object Onclick:
	def apply(): Onclick = new Onclick(false)
	def w(): Onclick = new Onclick(true)

	def :-(suffixValue: String): Onclick = 
		var ret = new Onclick(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onclick = 
		var ret = new Onclick(true)
		ret.suffix = suffixValue
		ret