package fhtml.attributes

import fhtml.*

class Oncuechange(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("track")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"track" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox(""),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"oncuechange=\"$suffix\""
	def getSuffix:               String = suffix

object Oncuechange:
	def apply(): Oncuechange = new Oncuechange(false)
	def w(): Oncuechange = new Oncuechange(true)

	def :-(suffixValue: String): Oncuechange = 
		var ret = new Oncuechange(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Oncuechange = 
		var ret = new Oncuechange(true)
		ret.suffix = suffixValue
		ret