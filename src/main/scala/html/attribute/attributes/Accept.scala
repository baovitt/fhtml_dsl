package fhtml.attributes

import fhtml.*

class Accept(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"input" -> (
					Chrome( "8.0"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "15.0"),
					Safari( "6.0")
				)
			)
		)

	def getAttribute:            String = s"accept=\"$suffix\""
	def getSuffix:               String = suffix

object Accept:
	def apply(): Accept = new Accept(false)
	def w(): Accept = new Accept(true)

	def :-(suffixValue: String): Accept = 
		var ret = new Accept(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Accept = 
		var ret = new Accept(true)
		ret.suffix = suffixValue
		ret