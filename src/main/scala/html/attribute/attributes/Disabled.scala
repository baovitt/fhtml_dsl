package fhtml.attributes

import fhtml.*

class Disabled(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("button", "fieldset", "input", "optgroup", "option", "select", "textarea")
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
					Safari( "7.0")
				),
				"input" -> (
					Chrome( "1.0"),
					Edge(   "6.0"),
					Firefox("1.0"),
					Opera(  "1.0"),
					Safari( "1.0")
				),
				"optgroup" -> (
					Chrome( "1.0"),
					Edge(   "8.0"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"option" -> (
					Chrome( "1.0"),
					Edge(   "8.0"),
					Firefox("1.0"),
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

	def getAttribute:            String = "disabled"

object Disabled:
	def apply(): Disabled = new Disabled(false)
	def w: Disabled = new Disabled(true)