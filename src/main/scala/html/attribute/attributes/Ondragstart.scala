package fhtml.attributes

import fhtml.*

class Ondragstart(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"ondragstart=\"$suffix\""
	def getSuffix:               String = suffix

object Ondragstart:
	def apply(): Ondragstart = new Ondragstart(false)
	def w(): Ondragstart = new Ondragstart(true)

	def :-(suffixValue: String): Ondragstart = 
		var ret = new Ondragstart(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Ondragstart = 
		var ret = new Ondragstart(true)
		ret.suffix = suffixValue
		ret