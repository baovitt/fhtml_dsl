package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Ol(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<ol ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</ol>"

object Ol:
  def apply(tags: HTMLTag*): Ol =
    new Ol(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Ol =
    new Ol(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Ol =
    TagUtils.getWarning("ol")(attributes*)
    new Ol(true)(attributes*)(tags*)
