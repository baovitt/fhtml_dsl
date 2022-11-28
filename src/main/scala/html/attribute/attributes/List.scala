package fhtml.attributes

import fhtml.*

class List(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("input")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"input" -> (
					Chrome( "20.0"),
					Edge(   "10.0"),
					Firefox("4.0"),
					Opera(  "9.6"),
					Safari( "")
				)
			)
		)

	def getAttribute:            String = s"list=\"$suffix\""
	def getSuffix:               String = suffix

object List:
	def apply(): List = new List(false)
	def w(): List = new List(true)

	def :-(suffixValue: String): List = 
		var ret = new List(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): List = 
		var ret = new List(true)
		ret.suffix = suffixValue
		ret