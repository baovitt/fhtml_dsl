package fhtml.attributes

import fhtml.*

class Cite(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("blockquote", "del", "ins", "q")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"blockquote" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"del" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"ins" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"q" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"cite=\"$suffix\""
	def getSuffix:               String = suffix

object Cite:
	def apply(): Cite = new Cite(false)
	def w(): Cite = new Cite(true)

	def :-(suffixValue: String): Cite = 
		var ret = new Cite(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Cite = 
		var ret = new Cite(true)
		ret.suffix = suffixValue
		ret
