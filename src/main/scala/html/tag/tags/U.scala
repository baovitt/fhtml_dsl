package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class U(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<u ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</u>"

object U:
  def apply(tags: HTMLTag*): U =
    new U(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): U =
    new U(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): U =
    TagUtils.getWarning("u")(attributes*)
    new U(true)(attributes*)(tags*)
