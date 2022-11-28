package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Sup(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<sup ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</sup>"

object Sup:
  def apply(tags: HTMLTag*): Sup =
    new Sup(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Sup =
    new Sup(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Sup =
    TagUtils.getWarning("sup")(attributes*)
    new Sup(true)(attributes*)(tags*)
