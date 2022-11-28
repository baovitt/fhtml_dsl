package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Samp(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<samp ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</samp>"

object Samp:
  def apply(tags: HTMLTag*): Samp =
    new Samp(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Samp =
    new Samp(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Samp =
    TagUtils.getWarning("samp")(attributes*)
    new Samp(true)(attributes*)(tags*)
