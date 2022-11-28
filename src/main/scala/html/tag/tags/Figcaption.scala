package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Figcaption(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "8.0"),
    Edge(   "9.0"),
    Firefox("4.0"),
    Opera(  "11.0"),
    Safari( "5.1")
  )

  def getTag: String =
    s"<figcaption ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</figcaption>"

object Figcaption:
	def apply(tags: HTMLTag*): Figcaption =
		new Figcaption(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Figcaption =
		new Figcaption(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Figcaption =
		TagUtils.getWarning("figcaption")(attributes*)
		new Figcaption(true)(attributes*)(tags*)