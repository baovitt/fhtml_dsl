package fhtml.attributes

import fhtml.*

class Ondrag(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"ondrag=\"$suffix\""
	def getSuffix:               String = suffix

object Ondrag:
	def apply(): Ondrag = new Ondrag(false)
	def w(): Ondrag = new Ondrag(true)

	def :-(suffixValue: String): Ondrag = 
		var ret = new Ondrag(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Ondrag = 
		var ret = new Ondrag(true)
		ret.suffix = suffixValue
		ret