package fhtml.attributes

import fhtml.*

class Onerror(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "body", "embed", "img", "link", "object", "script", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"audio" -> (
					Chrome( "All"),
					Edge(   "9.0"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"body" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"embed" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"img" -> (
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
				"object" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"script" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"video" -> (
					Chrome( "All"),
					Edge(   "9.0"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
			)
		)

	def getAttribute:            String = s"onerror=\"$suffix\""
	def getSuffix:               String = suffix

object Onerror:
	def apply(): Onerror = new Onerror(false)
	def w(): Onerror = new Onerror(true)

	def :-(suffixValue: String): Onerror = 
		var ret = new Onerror(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onerror = 
		var ret = new Onerror(true)
		ret.suffix = suffixValue
		ret