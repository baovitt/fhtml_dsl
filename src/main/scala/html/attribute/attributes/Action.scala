package fhtml.attributes

import fhtml.*

class Action(showWarning: Boolean) extends ParamAttribute(showWarning):
	private var suffix: String = ""
	val supportedTags: Array[String] = Array("form")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map (
				"form" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute:            String = s"action=\"$suffix\""
	def getSuffix:               String = suffix

object Action:
	def apply(): Action = new Action(false)
	def w(): Action = new Action(true)

	def :-(suffixValue: String): Action = 
		var ret = new Action(false)
		ret.suffix = suffixValue
		ret

	def :*(suffixValue: String): Action = 
		var ret = new Action(true)
		ret.suffix = suffixValue
		ret