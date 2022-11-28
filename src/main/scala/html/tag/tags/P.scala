package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class P(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<p ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</p>"

object P:
  def apply(tags: HTMLTag*): P =
    new P(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): P =
    new P(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): P =
    TagUtils.getWarning("p")(attributes*)
    new P(true)(attributes*)(tags*)