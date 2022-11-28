package fhtml.attributes

import fhtml.*

class Src(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "embed", "iframe", "img", "input", "script", "source", "track", "video")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"audio" -> (
					Chrome( "4.0"),
					Edge(   "9.0"),
					Firefox("3.5"),
					Opera(  "10.5"),
					Safari( "4.0")
				),
				"embed" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"iframe" -> (
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
				"input" -> (
					Chrome( "1.0"),
					Edge(   "2.0"),
					Firefox("1.0"),
					Opera(  "1.0"),
					Safari( "1.0")
				),
				"script" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				),
				"source" -> (
					Chrome( "4.0"),
					Edge(   "9.0"),
					Firefox("3.5"),
					Opera(  "10.5"),
					Safari( "4.0")
				),
				"track" -> (
					Chrome( "18.0"),
					Edge(   "10.0"),
					Firefox("31.0"),
					Opera(  "15.0"),
					Safari( "6.0")
				),
				"video" -> (
					Chrome( "4.0"),
					Edge(   "9.0"),
					Firefox("3.5"),
					Opera(  "10.5"),
					Safari( "4.0")
				)
			)
		)

	def getAttribute:            String = s"src=\"$suffix\""
	def getSuffix:               String = suffix

object Src:
	def apply(): Src = new Src(false)
	def w(): Src = new Src(true)

	def :-(suffixValue: String): Src = 
		var ret = new Src(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Src = 
		var ret = new Src(true)
		ret.suffix = suffixValue
		ret