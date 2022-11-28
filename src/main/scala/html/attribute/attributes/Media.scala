package fhtml.attributes

import fhtml.*

class Media(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("a", "area", "link", "source", "style")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"a" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"area" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"link" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"source" -> (
					Chrome( ""),
					Edge(   ""),
					Firefox(""),
					Opera(  ""),
					Safari( "")
				),
				"style" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"media=\"$suffix\""
	def getSuffix:               String = suffix

object Media:
	def apply(): Media = new Media(false)
	def w(): Media = new Media(true)

	def :-(suffixValue: String): Media = 
		var ret = new Media(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Media = 
		var ret = new Media(true)
		ret.suffix = suffixValue
		ret