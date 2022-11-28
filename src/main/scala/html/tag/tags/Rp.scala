package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Rp(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "5.0"),
    Edge(   "5.5"),
    Firefox("38.0"),
    Opera(  "15.0"),
    Safari( "5.0")
  )

  def getTag: String =
    s"<rp ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</rp>"

object Rp:
  def apply(tags: HTMLTag*): Rp =
    new Rp(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Rp =
    new Rp(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Rp =
    TagUtils.getWarning("rp")(attributes*)
    new Rp(true)(attributes*)(tags*)