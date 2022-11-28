package fhtml.attributes

import fhtml.*

class Ondragover(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"ondragover=\"$suffix\""
	def getSuffix:               String = suffix

object Ondragover:
	def apply(): Ondragover = new Ondragover(false)
	def w(): Ondragover = new Ondragover(true)

	def :-(suffixValue: String): Ondragover = 
		var ret = new Ondragover(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Ondragover = 
		var ret = new Ondragover(true)
		ret.suffix = suffixValue
		ret