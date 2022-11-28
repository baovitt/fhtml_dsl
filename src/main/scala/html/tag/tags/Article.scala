package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Article(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<article ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</article>"

object Article:
	def apply(tags: HTMLTag*): Article =
		new Article(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Article =
		new Article(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Article =
		TagUtils.getWarning("article")(attributes*)
		new Article(true)(attributes*)(tags*)