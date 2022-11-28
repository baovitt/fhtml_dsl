package fhtml.attributes

import fhtml.*

class Onsearch(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("VISIBLES")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"All visible elements" -> (
					Chrome( "All"),
					Edge(   ""),
					Firefox(""),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)
	
	def getAttribute:            String = s"onsearch=\"$suffix\""
	def getSuffix:               String = suffix

object Onsearch:
	def apply(): Onsearch = new Onsearch(false)
	def w(): Onsearch = new Onsearch(true)

	def :-(suffixValue: String): Onsearch = 
		var ret = new Onsearch(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onsearch = 
		var ret = new Onsearch(true)
		ret.suffix = suffixValue
		ret