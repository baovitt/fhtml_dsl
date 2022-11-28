package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Select(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<select ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</select>"

object Select:
  def apply(tags: HTMLTag*): Select =
    new Select(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Select =
    new Select(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Select =
    TagUtils.getWarning("select")(attributes*)
    new Select(true)(attributes*)(tags*)
