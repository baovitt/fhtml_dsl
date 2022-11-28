package fhtml.attributes

import fhtml.*

class Target(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("a", "area", "base", "form")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"a" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"area" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"base" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"form" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"target=\"$suffix\""
	def getSuffix:               String = suffix

object Target:
	def apply(): Target = new Target(false)
	def w(): Target = new Target(true)

	def :-(suffixValue: String): Target = 
		var ret = new Target(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Target = 
		var ret = new Target(true)
		ret.suffix = suffixValue
		ret