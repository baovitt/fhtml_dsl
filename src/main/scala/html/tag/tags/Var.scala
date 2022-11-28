package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Var(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<var ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</var>"

object Var:
  def apply(tags: HTMLTag*): Var =
    new Var(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Var =
    new Var(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Var =
    TagUtils.getWarning("var")(attributes*)
    new Var(true)(attributes*)(tags*)