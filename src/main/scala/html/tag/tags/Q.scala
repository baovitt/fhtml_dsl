package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Q(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<q ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</q>"

object Q:
  def apply(tags: HTMLTag*): Q =
    new Q(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Q =
    new Q(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Q =
    TagUtils.getWarning("q")(attributes*)
    new Q(true)(attributes*)(tags*)
