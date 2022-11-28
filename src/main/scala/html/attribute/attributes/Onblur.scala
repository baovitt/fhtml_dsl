package fhtml.attributes

import fhtml.*

class Onblur(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onblur=\"$suffix\""
	def getSuffix:               String = suffix

object Onblur:
	def apply(): Onblur = new Onblur(false)
	def w(): Onblur = new Onblur(true)

	def :-(suffixValue: String): Onblur = 
		var ret = new Onblur(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onblur = 
		var ret = new Onblur(true)
		ret.suffix = suffixValue
		ret