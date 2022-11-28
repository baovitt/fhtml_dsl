package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Td(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<td ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</td>"

object Td:
  def apply(tags: HTMLTag*): Td =
    new Td(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Td =
    new Td(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Td =
    TagUtils.getWarning("td")(attributes*)
    new Td(true)(attributes*)(tags*)
