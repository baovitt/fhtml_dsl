package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Input(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<input ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Input:

	def apply(attributes: Attribute*): Input =
		new Input(false)(attributes*)

	def w(attributes: Attribute*): Input =
		TagUtils.getWarning("input")(attributes*)
		new Input(true)(attributes*)