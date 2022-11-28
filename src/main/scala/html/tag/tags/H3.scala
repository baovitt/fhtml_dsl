package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class H3(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<h3 ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</h3>"

object H3:
	def apply(tags: HTMLTag*): H3 =
		new H3(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): H3 =
		new H3(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): H3 =
		TagUtils.getWarning("h3")(attributes*)
		new H3(true)(attributes*)(tags*)