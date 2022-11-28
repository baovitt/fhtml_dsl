package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class HtmlT(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<html ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</html>"

object HtmlT:
	def apply(tags: HTMLTag*): HtmlT =
		new HtmlT(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): HtmlT =
		new HtmlT(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): HtmlT =
		TagUtils.getWarning("html")(attributes*)
		new HtmlT(true)(attributes*)(tags*)