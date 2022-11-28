package fhtml.attributes

import fhtml.*

class Srcdoc(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("iframe")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"iframe" -> (
					Chrome( "20.0"),
					Edge(   ""),
					Firefox("25.0"),
					Opera(  "15.0"),
					Safari( "6.0")
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"srcdoc=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

object Srcdoc:
	def apply(): Srcdoc = new Srcdoc(false)
	def w(): Srcdoc = new Srcdoc(true)

	def :-(suffixValue: String): Srcdoc = 
		var ret = new Srcdoc(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Srcdoc = 
		var ret = new Srcdoc(true)
		ret.suffix = suffixValue
		ret