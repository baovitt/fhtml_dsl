package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Colgroup(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<colgroup ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</colgroup>"

object Colgroup:
	def apply(tags: HTMLTag*): Colgroup =
		new Colgroup(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Colgroup =
		new Colgroup(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Colgroup =
		TagUtils.getWarning("colgroup")(attributes*)
		new Colgroup(true)(attributes*)(tags*)