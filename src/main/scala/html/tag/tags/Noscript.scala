package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Noscript(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<noscript ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</noscript>"

object Noscript:
  def apply(tags: HTMLTag*): Noscript =
    new Noscript(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Noscript =
    new Noscript(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Noscript =
    TagUtils.getWarning("noscript")(attributes*)
    new Noscript(true)(attributes*)(tags*)