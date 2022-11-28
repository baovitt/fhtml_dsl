package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Bdo(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<bdo ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</bdo>"

object Bdo:
	def apply(tags: HTMLTag*): Bdo =
		new Bdo(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Bdo =
		new Bdo(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Bdo =
		TagUtils.getWarning("bdo")(attributes*)
		new Bdo(true)(attributes*)(tags*)