package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Embed(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<embed ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Embed:

	def apply(attributes: Attribute*): Embed =
		new Embed(false)(attributes*)

	def w(attributes: Attribute*): Embed =
		TagUtils.getWarning("embed")(attributes*)
		new Embed(true)(attributes*)