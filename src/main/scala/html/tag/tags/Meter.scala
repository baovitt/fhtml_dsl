package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Meter(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "8.0"),
    Edge(   "13.0"),
    Firefox("16.0"),
    Opera(  "11.5"),
    Safari( "6.0")
  )

  def getTag: String =
    s"<meter ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</meter>"

object Meter:
  def apply(tags: HTMLTag*): Meter =
    new Meter(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Meter =
    new Meter(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Meter =
    TagUtils.getWarning("meter")(attributes*)
    new Meter(true)(attributes*)(tags*)