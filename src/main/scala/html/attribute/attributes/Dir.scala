package fhtml.attributes

import fhtml.*

class Dir(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"dir=\"$suffix\""
	def getSuffix:               String = suffix

object Dir:
	def apply(): Dir = new Dir(false)
	def w(): Dir = new Dir(true)

	def :-(suffixValue: String): Dir = 
		var ret = new Dir(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Dir = 
		var ret = new Dir(true)
		ret.suffix = suffixValue
		ret