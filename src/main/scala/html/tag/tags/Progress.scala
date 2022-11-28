package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Progress(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "8.0"),
    Edge(   "10.0"),
    Firefox("16.0"),
    Opera(  "11.0"),
    Safari( "6.0")
  )

  def getTag: String =
    s"<progress ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</progress>"

object Progress:
  def apply(tags: HTMLTag*): Progress =
    new Progress(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Progress =
    new Progress(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Progress =
    TagUtils.getWarning("progress")(attributes*)
    new Progress(true)(attributes*)(tags*)