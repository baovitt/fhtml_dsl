package fhtml.attributes

import fhtml.*

class Wrap(showWarning: Boolean) extends ParamAttribute(showWarning):
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

	def getAttribute:            String = s"wrap=\"$suffix\""
	def getSuffix:               String = suffix

object Wrap:
	def apply(): Wrap = new Wrap(false)
	def w(): Wrap = new Wrap(true)

	def :-(suffixValue: String): Wrap = 
		var ret = new Wrap(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Wrap = 
		var ret = new Wrap(true)
		ret.suffix = suffixValue
		ret
