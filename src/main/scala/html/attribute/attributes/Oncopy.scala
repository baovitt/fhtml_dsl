package fhtml.attributes

import fhtml.*

class Oncopy(showWarning: Boolean) extends ParamAttribute(showWarning):
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
	
	def getAttribute:            String = s"oncopy=\"$suffix\""
	def getSuffix:               String = suffix

object Oncopy:
	def apply(): Oncopy = new Oncopy(false)
	def w(): Oncopy = new Oncopy(true)

	def :-(suffixValue: String): Oncopy = 
		var ret = new Oncopy(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Oncopy = 
		var ret = new Oncopy(true)
		ret.suffix = suffixValue
		ret