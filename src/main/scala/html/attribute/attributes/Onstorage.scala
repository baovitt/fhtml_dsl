package fhtml.attributes

import fhtml.*

class Onstorage(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("body")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"body" -> (
					Chrome( "Unknown"),
					Edge(   "Unknown"),
					Firefox("Unknown"),
					Opera(  "Unknown"),
					Safari( "Unknown")
				)
			)
		)

	def ->(suffixValue: String): Attribute = 
		suffix = suffixValue
		this
	def getAttribute:            String = s"onstorage=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

object Onstorage:
	def apply(): Onstorage = new Onstorage(false)
	def w(): Onstorage = new Onstorage(true)

	def :-(suffixValue: String): Onstorage = 
		var ret = new Onstorage(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onstorage = 
		var ret = new Onstorage(true)
		ret.suffix = suffixValue
		ret