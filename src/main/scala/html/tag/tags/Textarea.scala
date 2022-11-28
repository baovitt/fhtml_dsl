package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Textarea(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<textarea ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</textarea>"

object Textarea:
  def apply(tags: HTMLTag*): Textarea =
    new Textarea(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Textarea =
    new Textarea(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Textarea =
    TagUtils.getWarning("textarea")(attributes*)
    new Textarea(true)(attributes*)(tags*)
