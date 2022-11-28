package fhtml.attributes

import fhtml.*

class Oncontextmenu(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"oncontextmenu=\"$suffix\""
	def getSuffix:               String = suffix

object Oncontextmenu:
	def apply(): Oncontextmenu = new Oncontextmenu(false)
	def w(): Oncontextmenu = new Oncontextmenu(true)

	def :-(suffixValue: String): Oncontextmenu = 
		var ret = new Oncontextmenu(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Oncontextmenu = 
		var ret = new Oncontextmenu(true)
		ret.suffix = suffixValue
		ret