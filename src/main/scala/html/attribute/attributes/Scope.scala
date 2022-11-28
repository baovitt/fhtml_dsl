package fhtml.attributes

import fhtml.*

class Scope(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("th")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"th" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"scope=\"$suffix\""
	def getSuffix:               String = suffix

object Scope:
	def apply(): Scope = new Scope(false)
	def w(): Scope = new Scope(true)

	def :-(suffixValue: String): Scope = 
		var ret = new Scope(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Scope = 
		var ret = new Scope(true)
		ret.suffix = suffixValue
		ret