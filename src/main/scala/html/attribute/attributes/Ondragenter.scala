package fhtml.attributes

import fhtml.*

class Ondragenter(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"ondragenter=\"$suffix\""
	def getSuffix:               String = suffix

object Ondragenter:
	def apply(): Ondragenter = new Ondragenter(false)
	def w(): Ondragenter = new Ondragenter(true)

	def :-(suffixValue: String): Ondragenter = 
		var ret = new Ondragenter(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Ondragenter = 
		var ret = new Ondragenter(true)
		ret.suffix = suffixValue
		ret