package fhtml.attributes

import fhtml.*

class Oncut(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"All visible elements" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"oncut=\"$suffix\""
	def getSuffix:               String = suffix

object Oncut:
	def apply(): Oncut = new Oncut(false)
	def w(): Oncut = new Oncut(true)

	def :-(suffixValue: String): Oncut = 
		var ret = new Oncut(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Oncut = 
		var ret = new Oncut(true)
		ret.suffix = suffixValue
		ret