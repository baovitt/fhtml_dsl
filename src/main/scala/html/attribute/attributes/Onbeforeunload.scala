package fhtml.attributes

import fhtml.*

class Onbeforeunload(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"body" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "15.0"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"onbeforeunload=\"$suffix\""
	def getSuffix:               String = suffix

object Onbeforeunload:
	def apply(): Onbeforeunload = new Onbeforeunload(false)
	def w(): Onbeforeunload = new Onbeforeunload(true)

	def :-(suffixValue: String): Onbeforeunload = 
		var ret = new Onbeforeunload(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onbeforeunload = 
		var ret = new Onbeforeunload(true)
		ret.suffix = suffixValue
		ret