package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Th(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<th ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</th>"

object Th:
  def apply(tags: HTMLTag*): Th =
    new Th(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Th =
    new Th(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Th =
    TagUtils.getWarning("th")(attributes*)
    new Th(true)(attributes*)(tags*)
