package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Bdi(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "16.0"),
    Edge(   "79.0"),
    Firefox("10.0"),
    Opera(  ""),
    Safari( "15.0")
  )

  def getTag: String =
    s"<bdi ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</bdi>"

object Bdi:
	def apply(tags: HTMLTag*): Bdi =
		new Bdi(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Bdi =
		new Bdi(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Bdi =
		TagUtils.getWarning("bdi")(attributes*)
		new Bdi(true)(attributes*)(tags*)