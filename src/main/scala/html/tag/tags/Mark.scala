package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Mark(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "6.0"),
    Edge(   "9.0"),
    Firefox("4.0"),
    Opera(  "11.1"),
    Safari( "5.0")
  )

  def getTag: String =
    s"<mark ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</mark>"

object Mark:
  def apply(tags: HTMLTag*): Mark =
    new Mark(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Mark =
    new Mark(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Mark =
    TagUtils.getWarning("mark")(attributes*)
    new Mark(true)(attributes*)(tags*)
