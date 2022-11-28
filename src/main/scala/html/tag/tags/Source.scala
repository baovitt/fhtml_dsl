package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Source(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
      Chrome( "4.0"),
      Edge(   "9.0"),
      Firefox("3.5"),
      Opera(  "10.5"),
      Safari( "4.0")
    )

  def getTag: String =
    s"<source ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Source:

  def apply(attributes: Attribute*): Source =
    new Source(false)(attributes*)

  def w(attributes: Attribute*): Source =
    TagUtils.getWarning("source")(attributes*)
    new Source(true)(attributes*)
