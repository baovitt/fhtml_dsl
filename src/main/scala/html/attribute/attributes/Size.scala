package fhtml.attributes

import fhtml.*

class Size(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input", "select")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"input" -> (
					Chrome( "1.0"),
					Edge(   "2.0"),
					Firefox("1.0"),
					Opera(  "1.0"),
					Safari( "1.0")
				),
				"select" -> (
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
	def getAttribute:            String = s"size=\"$suffix\""
	def getSuffix:               String = suffix
	def this() = this(DefaultWarningValue)

object Size:
	def apply(): Size = new Size(false)
	def w(): Size = new Size(true)

	def :-(suffixValue: String): Size = 
		var ret = new Size(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Size = 
		var ret = new Size(true)
		ret.suffix = suffixValue
		ret