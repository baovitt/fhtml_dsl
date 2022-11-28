package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Img(showWarning: Boolean)(var attributes: Attribute*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<img ${attributes.map(_.getAttribute).mkString(" ")}>"

object Img:
  def apply(attributes: Attribute*): Img =
    new Img(false)(attributes*)

  def w(attributes: Attribute*): Img =
    TagUtils.getWarning("img")(attributes*)
    new Img(true)(attributes*)