package fhtml.attributes

import fhtml.*

class HttpEquiv(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("meta")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"meta" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"http-equiv=\"$suffix\""
	def getSuffix:               String = suffix

object HttpEquiv:
	def apply(): HttpEquiv = new HttpEquiv(false)
	def w(): HttpEquiv = new HttpEquiv(true)

	def :-(suffixValue: String): HttpEquiv = 
		var ret = new HttpEquiv(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): HttpEquiv = 
		var ret = new HttpEquiv(true)
		ret.suffix = suffixValue
		ret