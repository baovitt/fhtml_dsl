package fhtml.attributes

import fhtml.*

class Onwheel(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"All visible elements" -> (
					Chrome( "31.0"),
					Edge(   ""),
					Firefox("17.0"),
					Opera(  "18.0"),
					Safari( "")
				)
			)
		)

	def getAttribute:            String = s"onwheel=\"$suffix\""
	def getSuffix:               String = suffix

object Onwheel:
	def apply(): Onwheel = new Onwheel(false)
	def w(): Onwheel = new Onwheel(true)

	def :-(suffixValue: String): Onwheel = 
		var ret = new Onwheel(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onwheel = 
		var ret = new Onwheel(true)
		ret.suffix = suffixValue
		ret