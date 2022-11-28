package fhtml.attributes

import fhtml.*

class AcceptCharset(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"accept-charset=\"$suffix\""
	def getSuffix:               String = suffix

object AcceptCharset:
	def apply(): AcceptCharset = new AcceptCharset(false)
	def w(): AcceptCharset = new AcceptCharset(true)

	def :-(suffixValue: String): AcceptCharset = 
		var ret = new AcceptCharset(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): AcceptCharset = 
		var ret = new AcceptCharset(true)
		ret.suffix = suffixValue
		ret