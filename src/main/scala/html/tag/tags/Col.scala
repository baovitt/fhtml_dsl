package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Col(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<col ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Col:

	def apply(attributes: Attribute*): Col =
		new Col(false)(attributes*)

	def w(attributes: Attribute*): Col =
		TagUtils.getWarning("col")(attributes*)
		new Col(true)(attributes*)