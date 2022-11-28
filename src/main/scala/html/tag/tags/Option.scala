package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Option(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<option ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</option>"

object Option:
  def apply(tags: HTMLTag*): Option =
    new Option(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Option =
    new Option(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Option =
    TagUtils.getWarning("option")(attributes*)
    new Option(true)(attributes*)(tags*)
