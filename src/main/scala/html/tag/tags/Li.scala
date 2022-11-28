package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Li(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<li ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</li>"

object Li:
  def apply(tags: HTMLTag*): Li =
    new Li(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Li =
    new Li(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Li =
    TagUtils.getWarning("li")(attributes*)
    new Li(true)(attributes*)(tags*)