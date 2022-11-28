package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Wbr(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "1.0"),
    Edge(   "12.0"),
    Firefox("3.0"),
    Opera(  "11.7"),
    Safari( "4.0")
  )

  def getTag: String =
    s"<wbr ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</wbr>"

object Wbr:
  def apply(tags: HTMLTag*): Wbr =
    new Wbr(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Wbr =
    new Wbr(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Wbr =
    TagUtils.getWarning("wbr")(attributes*)
    new Wbr(true)(attributes*)(tags*)
