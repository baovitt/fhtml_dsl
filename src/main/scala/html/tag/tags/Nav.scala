package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Nav(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "5.0"),
    Edge(   "9.0"),
    Firefox("4.0"),
    Opera(  "11.1"),
    Safari( "5.0")
  )

  def getTag: String =
    s"<nav ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</nav>"

object Nav:
  def apply(tags: HTMLTag*): Nav =
    new Nav(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Nav =
    new Nav(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Nav =
    TagUtils.getWarning("nav")(attributes*)
    new Nav(true)(attributes*)(tags*)
