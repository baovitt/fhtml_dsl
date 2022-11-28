package fhtml.attributes

import fhtml.*

class Onunload(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("details")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"details" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"onunload=\"$suffix\""
	def getSuffix:               String = suffix

object Onunload:
	def apply(): Onunload = new Onunload(false)
	def w(): Onunload = new Onunload(true)

	def :-(suffixValue: String): Onunload = 
		var ret = new Onunload(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onunload = 
		var ret = new Onunload(true)
		ret.suffix = suffixValue
		ret