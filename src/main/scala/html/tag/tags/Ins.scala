package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Ins(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<ins ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</ins>"

object Ins:
	def apply(tags: HTMLTag*): Ins =
		new Ins(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Ins =
		new Ins(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Ins =
		TagUtils.getWarning("ins")(attributes*)
		new Ins(true)(attributes*)(tags*)