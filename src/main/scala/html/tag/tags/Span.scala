package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Span(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<span ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</span>"

object Span:
  def apply(tags: HTMLTag*): Span =
    new Span(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Span =
    new Span(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Span =
    TagUtils.getWarning("span")(attributes*)
    new Span(true)(attributes*)(tags*)