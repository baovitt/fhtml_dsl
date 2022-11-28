package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Strong(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<strong ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</strong>"

object Strong:
  def apply(tags: HTMLTag*): Strong =
    new Strong(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Strong =
    new Strong(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Strong =
    TagUtils.getWarning("strong")(attributes*)
    new Strong(true)(attributes*)(tags*)
