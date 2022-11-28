package fhtml.attributes

import fhtml.*

class Onscroll(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"onscroll=\"$suffix\""
	def getSuffix:               String = suffix

object Onscroll:
	def apply(): Onscroll = new Onscroll(false)
	def w(): Onscroll = new Onscroll(true)

	def :-(suffixValue: String): Onscroll = 
		var ret = new Onscroll(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onscroll = 
		var ret = new Onscroll(true)
		ret.suffix = suffixValue
		ret