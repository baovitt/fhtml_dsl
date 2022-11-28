package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Section(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "5.0"),
    Edge(   "9.0"),
    Firefox("4.0"),
    Opera(  "11.5"),
    Safari( "5.0")
  )

  def getTag: String =
    s"<section ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</section>"

object Section:
  def apply(tags: HTMLTag*): Section =
    new Section(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Section =
    new Section(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Section =
    TagUtils.getWarning("section")(attributes*)
    new Section(true)(attributes*)(tags*)