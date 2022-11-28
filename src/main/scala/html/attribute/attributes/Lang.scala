package fhtml.attributes

import fhtml.*

class Lang(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array()
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"Global Attribute" -> (
					Chrome( "18.0"),
					Edge(   "10.0"),
					Firefox("31.0"),
					Opera(  "15.0"),
					Safari( "6.0")
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"lang=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

object Lang:
	def apply(): Lang = new Lang(false)
	def w(): Lang = new Lang(true)

	def :-(suffixValue: String): Lang = 
		var ret = new Lang(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Lang = 
		var ret = new Lang(true)
		ret.suffix = suffixValue
		ret