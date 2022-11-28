package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class H6(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<h6 ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</h6>"

object H6:
	def apply(tags: HTMLTag*): H6 =
		new H6(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): H6 =
		new H6(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): H6 =
		TagUtils.getWarning("h6")(attributes*)
		new H6(true)(attributes*)(tags*)