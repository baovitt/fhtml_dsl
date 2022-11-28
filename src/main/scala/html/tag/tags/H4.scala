package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class H4(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<h4 ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</h4>"

object H4:
	def apply(tags: HTMLTag*): H4 =
		new H4(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): H4 =
		new H4(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): H4 =
		TagUtils.getWarning("h4")(attributes*)
		new H4(true)(attributes*)(tags*)