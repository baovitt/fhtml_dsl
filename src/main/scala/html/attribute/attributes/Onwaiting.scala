package fhtml.attributes

import fhtml.*

class Onwaiting(showWarning: Boolean) extends ParamAttribute(showWarning):
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
	
	def getAttribute:            String = s"onwaiting=\"$suffix\""
	def getSuffix:               String = suffix

object Onwaiting:
	def apply(): Onwaiting = new Onwaiting(false)
	def w(): Onwaiting = new Onwaiting(true)

	def :-(suffixValue: String): Onwaiting = 
		var ret = new Onwaiting(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Onwaiting = 
		var ret = new Onwaiting(true)
		ret.suffix = suffixValue
		ret