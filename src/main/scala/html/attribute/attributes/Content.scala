package fhtml.attributes

import fhtml.*

class Content(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("meta")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"td" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"content=\"$suffix\""
	def getSuffix:               String = suffix

object Content:
	def apply(): Content = new Content(false)
	def w(): Content = new Content(true)

	def :-(suffixValue: String): Content = 
		var ret = new Content(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Content = 
		var ret = new Content(true)
		ret.suffix = suffixValue
		ret