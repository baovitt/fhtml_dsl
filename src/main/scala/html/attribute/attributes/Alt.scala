package fhtml.attributes

import fhtml.*

class Alt(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("area", "img", "input")
	val browserSupport: AttributeSupport = 
		AttributeSupport(
			scala.collection.immutable.Map(
				"area" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"img" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"input" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"alt=\"$suffix\""
	def getSuffix:               String = suffix

object Alt:
	def apply(): Alt = new Alt(false)
	def w(): Alt = new Alt(true)

	def :-(suffixValue: String): Alt = 
		var ret = new Alt(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Alt = 
		var ret = new Alt(true)
		ret.suffix = suffixValue
		ret