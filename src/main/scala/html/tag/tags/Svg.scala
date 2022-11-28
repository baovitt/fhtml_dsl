package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Svg(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "4.0"),
    Edge(   "9.0"),
    Firefox("3.0"),
    Opera(  "10.1"),
    Safari( "3.2")
  )

  def getTag: String =
    s"<svg ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</svg>"

object Svg:
  def apply(tags: HTMLTag*): Svg =
    new Svg(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Svg =
    new Svg(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Svg =
    TagUtils.getWarning("svg")(attributes*)
    new Svg(true)(attributes*)(tags*)