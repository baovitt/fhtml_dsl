package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Kbd(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<kdb ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</kdb>"

object Kbd:
	def apply(tags: HTMLTag*): Kbd =
		new Kbd(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Kbd =
		new Kbd(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Kbd =
		TagUtils.getWarning("kdb")(attributes*)
		new Kbd(true)(attributes*)(tags*)