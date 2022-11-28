package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Tbody(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<tbody ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</tbody>"

object Tbody:
  def apply(tags: HTMLTag*): Tbody =
    new Tbody(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Tbody =
    new Tbody(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Tbody =
    TagUtils.getWarning("tbody")(attributes*)
    new Tbody(true)(attributes*)(tags*)