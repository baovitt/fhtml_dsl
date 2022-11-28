package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Audio(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
      Chrome( "4.0"),
      Edge(   "9.0"),
      Firefox("3.5"),
      Opera(  "4.0"),
      Safari( "11.5")
    )

  def getTag: String =
    s"<audio ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Audio:

	def apply(attributes: Attribute*): Audio =
		new Audio(false)(attributes*)

	def w(attributes: Attribute*): Audio =
		TagUtils.getWarning("audio")(attributes*)
		new Audio(true)(attributes*)