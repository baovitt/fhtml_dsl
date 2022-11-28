package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Label(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<label ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</label>"

object Label:
	def apply(tags: HTMLTag*): Label =
		new Label(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Label =
		new Label(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Label =
		TagUtils.getWarning("label")(attributes*)
		new Label(true)(attributes*)(tags*)