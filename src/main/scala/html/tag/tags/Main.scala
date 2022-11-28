package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class MainT(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<main ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</main>"

object MainT:
  def apply(tags: HTMLTag*): MainT =
    new MainT(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): MainT =
    new MainT(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): MainT =
    TagUtils.getWarning("main")(attributes*)
    new MainT(true)(attributes*)(tags*)