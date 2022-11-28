package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Rt(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "5.0"),
    Edge(   "5.5"),
    Firefox("38.0"),
    Opera(  "15.0"),
    Safari( "5.0")
  )

  def getTag: String =
    s"<rt ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</rt>"

object Rt:
  def apply(tags: HTMLTag*): Rt =
    new Rt(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Rt =
    new Rt(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Rt =
    TagUtils.getWarning("rt")(attributes*)
    new Rt(true)(attributes*)(tags*)