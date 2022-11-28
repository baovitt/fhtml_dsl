package fhtml.attributes

import fhtml.*

class TitleAttr(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"Global Attributes" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"title=\"$suffix\""
	def getSuffix:               String = suffix

object TitleAttr:
	def apply(): TitleAttr = new TitleAttr(false)
	def w(): TitleAttr = new TitleAttr(true)

	def :-(suffixValue: String): TitleAttr = 
		var ret = new TitleAttr(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): TitleAttr = 
		var ret = new TitleAttr(true)
		ret.suffix = suffixValue
		ret