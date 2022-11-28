package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Title(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<title ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</title>"

object Title:
  def apply(tags: HTMLTag*): Title =
    new Title(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Title =
    new Title(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Title =
    TagUtils.getWarning("title")(attributes*)
    new Title(true)(attributes*)(tags*)