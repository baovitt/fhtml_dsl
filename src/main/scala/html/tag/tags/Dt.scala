package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Dt(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<dt ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</dt>"

object Dt:
	def apply(tags: HTMLTag*): Dt =
		new Dt(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Dt =
		new Dt(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Dt =
		TagUtils.getWarning("dt")(attributes*)
		new Dt(true)(attributes*)(tags*)