package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class S(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<s ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</s>"

object S:
  def apply(tags: HTMLTag*): S =
    new S(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): S =
    new S(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): S =
    TagUtils.getWarning("s")(attributes*)
    new S(true)(attributes*)(tags*)
