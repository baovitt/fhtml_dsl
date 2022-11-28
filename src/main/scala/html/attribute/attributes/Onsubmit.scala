package fhtml.attributes

import fhtml.*

class Onsubmit(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("form")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"form" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"onsubmit=\"$suffix\""
	def getSuffix:               String = suffix

object Onsubmit:
	def apply(): Onsubmit = new Onsubmit(false)
	def w(): Onsubmit = new Onsubmit(true)

	def :-(suffixValue: String): Onsubmit = 
		var ret = new Onsubmit(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onsubmit = 
		var ret = new Onsubmit(true)
		ret.suffix = suffixValue
		ret
