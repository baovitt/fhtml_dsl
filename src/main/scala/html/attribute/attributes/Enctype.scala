package fhtml.attributes

import fhtml.*

class Enctype(showWarning: Boolean) extends ParamAttribute(showWarning):
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
	
	def getAttribute:            String = s"enctype=\"$suffix\""
	def getSuffix:               String = suffix

object Enctype:
	def apply(): Enctype = new Enctype(false)
	def w(): Enctype = new Enctype(true)

	def :-(suffixValue: String): Enctype = 
		var ret = new Enctype(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Enctype = 
		var ret = new Enctype(true)
		ret.suffix = suffixValue
		ret