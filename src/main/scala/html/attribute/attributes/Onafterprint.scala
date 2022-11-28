package fhtml.attributes

import fhtml.*

class Onafterprint(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"body" -> (
					Chrome( "63.0"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  ""),
					Safari( "")
				)
			)
		)

	def getAttribute:            String = s"onafterprint=\"$suffix\""
	def getSuffix:               String = suffix

object Onafterprint:
	def apply(): Onafterprint = new Onafterprint(false)
	def w(): Onafterprint = new Onafterprint(true)

	def :-(suffixValue: String): Onafterprint = 
		var ret = new Onafterprint(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onafterprint = 
		var ret = new Onafterprint(true)
		ret.suffix = suffixValue
		ret