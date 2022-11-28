package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Hr(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<hr ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Hr:

	def apply(attributes: Attribute*): Hr =
		new Hr(false)(attributes*)

	def w(attributes: Attribute*): Hr =
		TagUtils.getWarning("hr")(attributes*)
		new Hr(true)(attributes*)