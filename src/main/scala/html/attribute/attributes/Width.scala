package fhtml.attributes

import fhtml.*

class Width(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("canvas", "embed", "iframe", "img", "input", "object", "width")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"canvas" -> (
					Chrome( "4.0"),
					Edge(   "9.0"),
					Firefox("2.0"),
					Opera(  "9.0"),
					Safari( "3.1")
				),
				"embed" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"iframe" -> (
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
					Chrome( "1.0"),
					Edge(   "All"),
					Firefox("16.0"),
					Opera(  "1.0"),
					Safari( "All")
				),
				"object" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"width" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"width=\"$suffix\""
	def getSuffix:               String = suffix

object Width:
	def apply(): Width = new Width(false)
	def w(): Width = new Width(true)

	def :-(suffixValue: String): Width = 
		var ret = new Width(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Width = 
		var ret = new Width(true)
		ret.suffix = suffixValue
		ret