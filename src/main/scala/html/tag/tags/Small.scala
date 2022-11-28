package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Small(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<small ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</small>"

object Small:
  def apply(tags: HTMLTag*): Small =
    new Small(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Small =
    new Small(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Small =
    TagUtils.getWarning("small")(attributes*)
    new Small(true)(attributes*)(tags*)
