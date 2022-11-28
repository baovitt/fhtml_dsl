package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Ruby(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "5.0"),
    Edge(   "5.5"),
    Firefox("38.0"),
    Opera(  "15.0"),
    Safari( "5.0")
  )

  def getTag: String =
    s"<ruby ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</ruby>"

object Ruby:
  def apply(tags: HTMLTag*): Ruby =
    new Ruby(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Ruby =
    new Ruby(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Ruby =
    TagUtils.getWarning("ruby")(attributes*)
    new Ruby(true)(attributes*)(tags*)
