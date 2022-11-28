package fhtml.attributes

import fhtml.*

val DefaultWarningValue = true

abstract class Attribute(showWarning: Boolean):
	val supportedTags: Array[String]
	val browserSupport: AttributeSupport

	def getAttribute: String
	def getWarning = showWarning

abstract class NoParamAttribute(showWarning: Boolean) extends Attribute(showWarning)
abstract class ParamAttribute(showWarning: Boolean) extends Attribute(showWarning):
	// def ->(suffixValue: String): Attribute
	def getSuffix: String

class Style(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"Global Attributes" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"style=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)