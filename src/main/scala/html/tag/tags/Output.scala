package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Output(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "10.0"),
    Edge(   "13.0"),
    Firefox("4.0"),
    Opera(  "11.0"),
    Safari( "5.1")
  )

  def getTag: String =
    s"<output ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</output>"

object Output:
  def apply(tags: HTMLTag*): Output =
    new Output(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Output =
    new Output(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Output =
    TagUtils.getWarning("output")(attributes*)
    new Output(true)(attributes*)(tags*)