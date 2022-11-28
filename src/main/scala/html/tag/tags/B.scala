package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class B(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<b ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</b>"

object B:
	def apply(tags: HTMLTag*): B =
		new B(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): B =
		new B(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): B =
		TagUtils.getWarning("b")(attributes*)
		new B(true)(attributes*)(tags*)