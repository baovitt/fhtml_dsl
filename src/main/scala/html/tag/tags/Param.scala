package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Param(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<param ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Param:

  def apply(attributes: Attribute*): Param =
    new Param(false)(attributes*)

  def w(attributes: Attribute*): Param =
    TagUtils.getWarning("param")(attributes*)
    new Param(true)(attributes*)