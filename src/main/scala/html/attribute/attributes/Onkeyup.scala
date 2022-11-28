package fhtml.attributes

import fhtml.*

class Onkeyup(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body", "iframe", "img", "input", "link", "script", "style")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"body" -> (
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
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"link" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"script" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"style" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"onkeyup=\"$suffix\""
	def getSuffix:               String = suffix 

object Onkeyup:
	def apply(): Onkeyup = new Onkeyup(false)
	def w(): Onkeyup = new Onkeyup(true)

	def :-(suffixValue: String): Onkeyup = 
		var ret = new Onkeyup(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onkeyup = 
		var ret = new Onkeyup(true)
		ret.suffix = suffixValue
		ret