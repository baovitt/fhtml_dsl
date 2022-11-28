package fhtml.attributes

import fhtml.*

class Ondragend(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"ondragend=\"$suffix\""
	def getSuffix:               String = suffix

object Ondragend:
	def apply(): Ondragend = new Ondragend(false)
	def w(): Ondragend = new Ondragend(true)

	def :-(suffixValue: String): Ondragend = 
		var ret = new Ondragend(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Ondragend = 
		var ret = new Ondragend(true)
		ret.suffix = suffixValue
		ret