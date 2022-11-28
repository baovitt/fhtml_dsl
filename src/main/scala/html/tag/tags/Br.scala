package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Br(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<br ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Br:

	def apply(attributes: Attribute*): Br =
		new Br(false)(attributes*)

	def w(attributes: Attribute*): Br =
		TagUtils.getWarning("br")(attributes*)
		new Br(true)(attributes*)