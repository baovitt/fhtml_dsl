package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Summary(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "12.0"),
    Edge(   "79.0"),
    Firefox("49.0"),
    Opera(  "15.0"),
    Safari( "6.0")
  )

  def getTag: String =
    s"<summary ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</summary>"

object Summary:
  def apply(tags: HTMLTag*): Summary =
    new Summary(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Summary =
    new Summary(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Summary =
    TagUtils.getWarning("summary")(attributes*)
    new Summary(true)(attributes*)(tags*)
