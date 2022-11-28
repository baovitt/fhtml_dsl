package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Dfn(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<dfn ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</dfn>"

object Dfn:
	def apply(tags: HTMLTag*): Dfn =
		new Dfn(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Dfn =
		new Dfn(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Dfn =
		TagUtils.getWarning("dfn")(attributes*)
		new Dfn(true)(attributes*)(tags*)