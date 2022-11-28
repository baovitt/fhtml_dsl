package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Object(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<object ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</object>"

object Object:
  def apply(tags: HTMLTag*): Object =
    new Object(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Object =
    new Object(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Object =
    TagUtils.getWarning("object")(attributes*)
    new Object(true)(attributes*)(tags*)