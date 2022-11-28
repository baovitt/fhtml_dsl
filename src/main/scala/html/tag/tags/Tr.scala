package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Tr(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<tr ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</tr>"

object Tr:
  def apply(tags: HTMLTag*): Tr =
    new Tr(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Tr =
    new Tr(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Tr =
    TagUtils.getWarning("tr")(attributes*)
    new Tr(true)(attributes*)(tags*)
