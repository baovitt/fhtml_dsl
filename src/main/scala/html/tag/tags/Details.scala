package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Details(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "12.0"),
    Edge(   "79.0"),
    Firefox("49.0"),
    Opera(  "15.0"),
    Safari( "6.0")
  )

  def getTag: String =
    s"<details ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</details>"

object Details:
	def apply(tags: HTMLTag*): Details =
		new Details(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Details =
		new Details(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Details =
		TagUtils.getWarning("details")(attributes*)
		new Details(true)(attributes*)(tags*)