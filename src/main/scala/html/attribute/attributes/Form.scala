package fhtml.attributes

import fhtml.*

class Form(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("button", "fieldset", "input", "label", "meter", "object", "output", "select", "textarea")
	val browserSupport: AttributeSupport = 
		AttributeSupport(
			scala.collection.immutable.Map(
				"button" -> (
					Chrome( "10.0"),
					Edge(   ""),
					Firefox("4.0"),
					Opera(  "9.5"),
					Safari( "5.1")
				),
				"fieldset" -> (
					Chrome( ""),
					Edge(   ""),
					Firefox(""),
					Opera(  ""),
					Safari( "")
				),
				"input" -> (
					Chrome( "9.0"),
					Edge(   ""),
					Firefox("4.0"),
					Opera(  "10.6"),
					Safari( "5.1")
				),
				"label" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"meter" -> (
					Chrome( ""),
					Edge(   ""),
					Firefox(""),
					Opera(  ""),
					Safari( "")
				),
				"object" -> (
					Chrome( ""),
					Edge(   ""),
					Firefox(""),
					Opera(  ""),
					Safari( "")
				),
				"output" -> (
					Chrome( "All"),
					Edge(   ""),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"select" -> (
					Chrome( "All"),
					Edge(   ""),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"textarea" -> (
					Chrome( "All"),
					Edge(   ""),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			) 
		)

	def getAttribute:            String = s"form=\"$suffix\""
	def getSuffix:               String = suffix

object Form:
	def apply(): Form = new Form(false)
	def w(): Form = new Form(true)

	def :-(suffixValue: String): Form = 
		var ret = new Form(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Form = 
		var ret = new Form(true)
		ret.suffix = suffixValue
		ret