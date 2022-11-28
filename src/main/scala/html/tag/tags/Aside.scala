package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Aside(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "6.0"),
    Edge(   "9.0"),
    Firefox("4.0"),
    Opera(  "11.1"),
    Safari( "5.0")
  )

  def getTag: String =
    s"<aside ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</aside>"

object Aside:
	def apply(tags: HTMLTag*): Aside =
		new Aside(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Aside =
		new Aside(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Aside =
		TagUtils.getWarning("article")(attributes*)
		new Aside(true)(attributes*)(tags*)