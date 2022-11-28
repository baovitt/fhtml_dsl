package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class I(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<i ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</i>"

object I:
	def apply(tags: HTMLTag*): I =
		new I(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): I =
		new I(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): I =
		TagUtils.getWarning("i")(attributes*)
		new I(true)(attributes*)(tags*)