package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Button(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<button ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</button>"

object Button:
	def apply(tags: HTMLTag*): Button =
		new Button(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Button =
		new Button(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Button =
		TagUtils.getWarning("button")(attributes*)
		new Button(true)(attributes*)(tags*)