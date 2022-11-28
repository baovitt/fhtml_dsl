package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Base(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<base ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Base:

	def apply(attributes: Attribute*): Base =
		new Base(false)(attributes*)

	def w(attributes: Attribute*): Base =
		TagUtils.getWarning("base")(attributes*)
		new Base(true)(attributes*)