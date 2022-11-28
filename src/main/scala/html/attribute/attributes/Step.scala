package fhtml.attributes

import fhtml.*

class Step(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"input" -> (
					Chrome( "6.0"),
					Edge(   "10.0"),
					Firefox("16.0"),
					Opera(  "10.6"),
					Safari( "5.0")
				)
			)
		)

	def getAttribute:            String = s"step=\"$suffix\""
	def getSuffix:               String = suffix

object Step:
	def apply(): Step = new Step(false)
	def w(): Step = new Step(true)

	def :-(suffixValue: String): Step = 
		var ret = new Step(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Step = 
		var ret = new Step(true)
		ret.suffix = suffixValue
		ret