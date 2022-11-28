package fhtml.attributes

import fhtml.*

class Label(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("track")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"track" -> (
					Chrome( "18.0"),
					Edge(   "10.0"),
					Firefox("31.0"),
					Opera(  "15.0"),
					Safari( "6.0")
				)
			)
		)

	def getAttribute:            String = s"label=\"$suffix\""
	def getSuffix:               String = suffix

object Label:
	def apply(): Label = new Label(false)
	def w(): Label = new Label(true)

	def :-(suffixValue: String): Label = 
		var ret = new Label(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Label = 
		var ret = new Label(true)
		ret.suffix = suffixValue
		ret