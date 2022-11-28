package fhtml.attributes

import fhtml.*

class Dirname(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"input" -> (
					Chrome( "All"),
					Edge(   ""),
					Firefox(""),
					Opera(  "All"),
					Safari( "All")
				),
				"textarea" -> (
					Chrome( "All"),
					Edge(   ""),
					Firefox(""),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"dirname=\"$suffix\""
	def getSuffix:               String = suffix

object Dirname:
	def apply(): Dirname = new Dirname(false)
	def w(): Dirname = new Dirname(true)

	def :-(suffixValue: String): Dirname = 
		var ret = new Dirname(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Dirname = 
		var ret = new Dirname(true)
		ret.suffix = suffixValue
		ret