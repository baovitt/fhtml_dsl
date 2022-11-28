package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Abbr(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )


  def getTag: String =
    s"<abbr ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</abbr>"

object Abbr:
	def apply(tags: HTMLTag*): Abbr =
		new Abbr(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Abbr =
		new Abbr(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Abbr =
		TagUtils.getWarning("abbr")(attributes*)
		new Abbr(true)(attributes*)(tags*)