package fhtml.attributes

import fhtml.*

class Onresize(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"body" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"onresize=\"$suffix\""
	def getSuffix:               String = suffix

object Onresize:
	def apply(): Onresize = new Onresize(false)
	def w(): Onresize = new Onresize(true)

	def :-(suffixValue: String): Onresize = 
		var ret = new Onresize(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onresize = 
		var ret = new Onresize(true)
		ret.suffix = suffixValue
		ret