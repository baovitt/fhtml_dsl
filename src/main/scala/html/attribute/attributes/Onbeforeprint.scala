package fhtml.attributes

import fhtml.*

class Onbeforeprint(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"body" -> (
					Chrome( "63"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  ""),
					Safari( "")
				)
			)
		)

	def getAttribute:            String = s"onbeforeprint=\"$suffix\""
	def getSuffix:               String = suffix

object Onbeforeprint:
	def apply(): Onbeforeprint = new Onbeforeprint(false)
	def w(): Onbeforeprint = new Onbeforeprint(true)

	def :-(suffixValue: String): Onbeforeprint = 
		var ret = new Onbeforeprint(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onbeforeprint = 
		var ret = new Onbeforeprint(true)
		ret.suffix = suffixValue
		ret