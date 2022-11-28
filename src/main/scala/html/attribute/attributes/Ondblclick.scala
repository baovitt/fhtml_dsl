package fhtml.attributes

import fhtml.*

class Ondblclick(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"ondblclick=\"$suffix\""
	def getSuffix:               String = suffix

object Ondblclick:
	def apply(): Ondblclick = new Ondblclick(false)
	def w(): Ondblclick = new Ondblclick(true)

	def :-(suffixValue: String): Ondblclick = 
		var ret = new Ondblclick(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Ondblclick = 
		var ret = new Ondblclick(true)
		ret.suffix = suffixValue
		ret