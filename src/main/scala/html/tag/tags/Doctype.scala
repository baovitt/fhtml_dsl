package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Doctype(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<!DOCTYPE ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}"

object Doctype:
	def apply(tags: HTMLTag*): Doctype =
		new Doctype(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Doctype =
		new Doctype(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Doctype =
		TagUtils.getWarning("doctype")(attributes*)
		new Doctype(true)(attributes*)(tags*)