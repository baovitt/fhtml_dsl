package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Address(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )


  def getTag: String =
    s"<address ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</address>"

object Address:
	def apply(tags: HTMLTag*): Address =
		new Address(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Address =
		new Address(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Address =
		TagUtils.getWarning("address")(attributes*)
		new Address(true)(attributes*)(tags*)