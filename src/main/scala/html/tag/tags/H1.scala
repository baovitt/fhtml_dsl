package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class H1(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<h1 ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</h1>"

object H1:
	def apply(tags: HTMLTag*): H1 =
		new H1(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): H1 =
		new H1(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): H1 =
		TagUtils.getWarning("h1")(attributes*)
		new H1(true)(attributes*)(tags*)