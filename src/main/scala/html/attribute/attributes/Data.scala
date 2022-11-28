package fhtml.attributes

import fhtml.*

class Data(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("object")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"object" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"data=\"$suffix\""
	def getSuffix:               String = suffix

object Data:
	def apply(): Data = new Data(false)
	def w(): Data = new Data(true)

	def :-(suffixValue: String): Data = 
		var ret = new Data(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Data = 
		var ret = new Data(true)
		ret.suffix = suffixValue
		ret