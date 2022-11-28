package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Sub(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<sub ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</sub>"

object Sub:
  def apply(tags: HTMLTag*): Sub =
    new Sub(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Sub =
    new Sub(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Sub =
    TagUtils.getWarning("sub")(attributes*)
    new Sub(true)(attributes*)(tags*)
