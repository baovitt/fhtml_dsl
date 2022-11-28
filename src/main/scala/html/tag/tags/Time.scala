package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Time(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "62.0"),
    Edge(   "18.0"),
    Firefox("22.0"),
    Opera(  "49.0"),
    Safari( "7.0")
  )

  def getTag: String =
    s"<time ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</time>"

object Time:
  def apply(tags: HTMLTag*): Time =
    new Time(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Time =
    new Time(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Time =
    TagUtils.getWarning("time")(attributes*)
    new Time(true)(attributes*)(tags*)
