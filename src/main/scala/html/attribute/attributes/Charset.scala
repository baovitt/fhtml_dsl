package fhtml.attributes

import fhtml.*

class Charset(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("meta", "script")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"meta" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"script" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"charset=\"$suffix\""
	def getSuffix:               String = suffix

object Charset:
	def apply(): Charset = new Charset(false)
	def w(): Charset = new Charset(true)

	def :-(suffixValue: String): Charset = 
		var ret = new Charset(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Charset = 
		var ret = new Charset(true)
		ret.suffix = suffixValue
		ret