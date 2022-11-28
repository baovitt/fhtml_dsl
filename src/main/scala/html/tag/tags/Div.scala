package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Div(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<div ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</div>"

object Div:
	def apply(tags: HTMLTag*): Div =
		new Div(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Div =
		new Div(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Div =
		TagUtils.getWarning("div")(attributes*)
		new Div(true)(attributes*)(tags*)