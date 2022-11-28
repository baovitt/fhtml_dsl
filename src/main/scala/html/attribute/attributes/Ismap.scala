package fhtml.attributes

import fhtml.*

class Ismap(showWarning: Boolean) extends NoParamAttribute(showWarning):
	val supportedTags: Array[String] = Array("img")
	val browserSupport: AttributeSupport = 
		AttributeSupport( 
			scala.collection.immutable.Map(
				"img" -> (
					Chrome( "All"),
					Edge(   "All"),
					Firefox("All"),
					Opera(  "All"),
					Safari( "All")
				)
			)
		)

	def getAttribute: String = "ismap"
	
object Ismap:
	def apply(): Ismap = new Ismap(false)
	def w: Ismap = new Ismap(true)