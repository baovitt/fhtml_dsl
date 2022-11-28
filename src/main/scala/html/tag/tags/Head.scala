package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Head(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<head ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</head>"

object Head:
	def apply(tags: HTMLTag*): Head =
		new Head(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Head =
		new Head(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Head =
		TagUtils.getWarning("head")(attributes*)
		new Head(true)(attributes*)(tags*)