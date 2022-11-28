package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Link(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<link ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Link:

  def apply(attributes: Attribute*): Link =
    new Link(false)(attributes*)

  def w(attributes: Attribute*): Link =
    TagUtils.getWarning("link")(attributes*)
    new Link(true)(attributes*)