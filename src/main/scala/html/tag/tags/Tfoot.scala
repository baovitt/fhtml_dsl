package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Tfoot(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<tfoot ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</tfoot>"

object Tfoot:
  def apply(tags: HTMLTag*): Tfoot =
    new Tfoot(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Tfoot =
    new Tfoot(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Tfoot =
    TagUtils.getWarning("tfoot")(attributes*)
    new Tfoot(true)(attributes*)(tags*)
