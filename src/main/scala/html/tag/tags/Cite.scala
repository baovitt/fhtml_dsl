package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Cite(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<cite ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</cite>"

object Cite:
	def apply(tags: HTMLTag*): Cite =
		new Cite(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Cite =
		new Cite(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Cite =
		TagUtils.getWarning("cite")(attributes*)
		new Cite(true)(attributes*)(tags*)