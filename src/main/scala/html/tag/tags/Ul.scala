package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Ul(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<ul ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</ul>"

object Ul:
  def apply(tags: HTMLTag*): Ul =
    new Ul(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Ul =
    new Ul(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Ul =
    TagUtils.getWarning("ul")(attributes*)
    new Ul(true)(attributes*)(tags*)
