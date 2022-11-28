package fhtml.attributes

import fhtml.*

class Name(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("button", "fieldset", "form", "iframe", "input", "scala.collection.immutable.Map", "meta", "object", "output", "param", "select", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"button" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"fieldset" -> (
					Chrome( "All"),
					Edge(   ""),
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
				),
				"iframe" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"input" -> (
					Chrome( "1.0"),
					Edge(   "2.0"),
					Firefox("1.0"),
					Opera(  "1.0"),
					Safari( "1.0")
				),
				"map" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"meta" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"object" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"output" -> (
					Chrome( "10.0"),
					Edge(   ""),
					Firefox("4.0"),
					Opera(  "11.0"),
					Safari( "5.1")
				),
				"param" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"select" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"textarea" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"name=\"$suffix\""
	def getSuffix:               String = suffix

object Name:
	def apply(): Name = new Name(false)
	def w(): Name = new Name(true)

	def :-(suffixValue: String): Name = 
		var ret = new Name(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Name = 
		var ret = new Name(true)
		ret.suffix = suffixValue
		ret