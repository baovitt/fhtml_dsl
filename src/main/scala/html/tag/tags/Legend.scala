package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Legend(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<legend ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</legend>"

object Legend:
  def apply(tags: HTMLTag*): Legend =
    new Legend(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Legend =
    new Legend(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Legend =
    TagUtils.getWarning("legend")(attributes*)
    new Legend(true)(attributes*)(tags*)
