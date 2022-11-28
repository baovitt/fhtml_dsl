package fhtml.attributes

import fhtml.*

class Srcset(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("img", "source")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"img" -> (
					Chrome( "38.0"),
					Edge(   "13.0"),
					Firefox("38.0"),
					Opera(  "25.0"),
					Safari( "9.1")
				),
				"source" -> (
					Chrome( "38.0"),
					Edge(   "13.0"),
					Firefox("38.0"),
					Opera(  "25.0"),
					Safari( "9.1")
				)
			)
		)

	def getAttribute:            String = s"srcset=\"$suffix\""
	def getSuffix:               String = suffix

object Srcset:
	def apply(): Srcset = new Srcset(false)
	def w(): Srcset = new Srcset(true)

	def :-(suffixValue: String): Srcset = 
		var ret = new Srcset(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Srcset = 
		var ret = new Srcset(true)
		ret.suffix = suffixValue
		ret