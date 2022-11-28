package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Picture(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
      Chrome( "38.0"),
      Edge(   "13.0"),
      Firefox("38.0"),
      Opera(  "25.0"),
      Safari( "9.1")
    )

  def getTag: String =
    s"<picture ${attributes.map(_.getAttribute).mkString(" ")}>"

object Picture:

  def apply(attributes: Attribute*): Picture =
    new Picture(false)(attributes*)

  def w(attributes: Attribute*): Picture =
    TagUtils.getWarning("picture")(attributes*)
    new Picture(true)(attributes*)
