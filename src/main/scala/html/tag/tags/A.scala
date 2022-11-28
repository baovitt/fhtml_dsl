package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class A(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<a ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</a>"

object A:
	def apply(tags: HTMLTag*): A =
		new A(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): A =
		new A(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): A =
		TagUtils.getWarning("a")(attributes*)
		new A(true)(attributes*)(tags*)