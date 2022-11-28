package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Form(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<form ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</form>"

object Form:
	def apply(tags: HTMLTag*): Form =
		new Form(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Form =
		new Form(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Form =
		TagUtils.getWarning("form")(attributes*)
		new Form(true)(attributes*)(tags*)