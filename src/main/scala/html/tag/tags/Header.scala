package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Header(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "5.0"),
    Edge(   "9.0"),
    Firefox("4.0"),
    Opera(  "11.1"),
    Safari( "5.0")
  )

  def getTag: String =
    s"<header ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</header>"

object Header:
	def apply(tags: HTMLTag*): Header =
		new Header(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Header =
		new Header(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Header =
		TagUtils.getWarning("header")(attributes*)
		new Header(true)(attributes*)(tags*)