package fhtml.attributes

import fhtml.*

class Datatime(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("del", "ins", "time")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
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
				"time" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"datatime=\"$suffix\""
	def getSuffix:               String = suffix

object Datatime:
	def apply(): Datatime = new Datatime(false)
	def w(): Datatime = new Datatime(true)

	def :-(suffixValue: String): Datatime = 
		var ret = new Datatime(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Datatime = 
		var ret = new Datatime(true)
		ret.suffix = suffixValue
		ret