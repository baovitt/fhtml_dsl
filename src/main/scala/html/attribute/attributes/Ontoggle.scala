package fhtml.attributes

import fhtml.*

class Ontoggle(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("details")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"details" -> (
					Chrome( "12.0"),
					Edge(   ""),
					Firefox(""),
					Opera(  "15.0"),
					Safari( "6.0")
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"ontoggle=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

object Ontoggle:
	def apply(): Ontoggle = new Ontoggle(false)
	def w(): Ontoggle = new Ontoggle(true)

	def :-(suffixValue: String): Ontoggle = 
		var ret = new Ontoggle(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Ontoggle = 
		var ret = new Ontoggle(true)
		ret.suffix = suffixValue
		ret