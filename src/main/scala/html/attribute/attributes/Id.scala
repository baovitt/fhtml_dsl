package fhtml.attributes

import fhtml.*

class Id(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"Global Attribute" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"id=\"$suffix\""
	def getSuffix:               String = suffix

object Id:
	def apply(): Id = new Id(false)
	def w(): Id = new Id(true)

	def :-(suffixValue: String): Id = 
		var ret = new Id(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Id = 
		var ret = new Id(true)
		ret.suffix = suffixValue
		ret
