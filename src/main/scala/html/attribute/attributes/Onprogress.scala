package fhtml.attributes

import fhtml.*

class Onprogress(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("audio", "video")
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
				"video" -> (
					Chrome( "All"),
					Edge(   "9.0"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"onprogress=\"$suffix\""
	def getSuffix:               String = suffix

object Onprogress:
	def apply(): Onprogress = new Onprogress(false)
	def w(): Onprogress = new Onprogress(true)

	def :-(suffixValue: String): Onprogress = 
		var ret = new Onprogress(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onprogress = 
		var ret = new Onprogress(true)
		ret.suffix = suffixValue
		ret