package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Track(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
      Chrome( "23.0"),
      Edge(   "10.0"),
      Firefox("31.0"),
      Opera(  "12.1"),
      Safari( "6.0")
    )

  def getTag: String =
    s"<track ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Track:

  def apply(attributes: Attribute*): Track =
    new Track(false)(attributes*)

  def w(attributes: Attribute*): Track =
    TagUtils.getWarning("track")(attributes*)
    new Track(true)(attributes*)
