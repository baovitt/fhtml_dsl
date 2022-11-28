package fhtml.attributes

import fhtml.*

class Cols(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"textarea" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"cols=\"$suffix\""
	def getSuffix:               String = suffix

object Cols:
	def apply(): Cols = new Cols(false)
	def w(): Cols = new Cols(true)

	def :-(suffixValue: String): Cols = 
		var ret = new Cols(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Cols = 
		var ret = new Cols(true)
		ret.suffix = suffixValue
		ret
