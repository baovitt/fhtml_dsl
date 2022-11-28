package fhtml.attributes

import fhtml.*

class Onpageshow(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"All visible elements" -> (
					Chrome( "All"),
					Edge(   "11.0"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "5.0")
				)
			)
		)

	def getAttribute:            String = s"onpageshow=\"$suffix\""
	def getSuffix:               String = suffix 

object Onpageshow:
	def apply(): Onpageshow = new Onpageshow(false)
	def w(): Onpageshow = new Onpageshow(true)

	def :-(suffixValue: String): Onpageshow = 
		var ret = new Onpageshow(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onpageshow = 
		var ret = new Onpageshow(true)
		ret.suffix = suffixValue
		ret