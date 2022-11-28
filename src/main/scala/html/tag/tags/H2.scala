package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class H2(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<h2 ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</h2>"

object H2:
	def apply(tags: HTMLTag*): H2 =
		new H2(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): H2 =
		new H2(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): H2 =
		TagUtils.getWarning("h2")(attributes*)
		new H2(true)(attributes*)(tags*)