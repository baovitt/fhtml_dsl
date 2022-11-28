package fhtml.attributes

import fhtml.*

class Ondragleave(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"All visible elements" -> (
					Chrome( "4.0"),
					Edge(   "9.0"),
					Firefox("3.5"),
					Opera(  "12.0"),
					Safari( "6.0")
				)
			)
		)

	def getAttribute:            String = s"ondragleave=\"$suffix\""
	def getSuffix:               String = suffix

object Ondragleave:
	def apply(): Ondragleave = new Ondragleave(false)
	def w(): Ondragleave = new Ondragleave(true)

	def :-(suffixValue: String): Ondragleave = 
		var ret = new Ondragleave(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Ondragleave = 
		var ret = new Ondragleave(true)
		ret.suffix = suffixValue
		ret