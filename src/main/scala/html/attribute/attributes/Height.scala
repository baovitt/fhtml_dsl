package fhtml.attributes

import fhtml.*

class Height(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("canvas", "embed", "iframe", "img", "input", "object", "video")
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
				"video" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"height=\"$suffix\""
	def getSuffix:               String = suffix

object Height:
	def apply(): Height = new Height(false)
	def w(): Height = new Height(true)

	def :-(suffixValue: String): Height = 
		var ret = new Height(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Height = 
		var ret = new Height(true)
		ret.suffix = suffixValue
		ret