package fhtml.attributes

import fhtml.*

class Accesskey(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"accesskey=\"$suffix\""
	def getSuffix:               String = suffix

object Accesskey:
	def apply(): Accesskey = new Accesskey(false)
	def w(): Accesskey = new Accesskey(true)

	def :-(suffixValue: String): Accesskey = 
		var ret = new Accesskey(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Accesskey = 
		var ret = new Accesskey(true)
		ret.suffix = suffixValue
		ret