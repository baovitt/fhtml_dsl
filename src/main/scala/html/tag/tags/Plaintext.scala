package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Plaintext(showWarning: Boolean)(attributes: Attribute*)(text: String)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<div ${attributes.map(_.getAttribute).mkString(" ")}>${Plaintext.format(StringBuilder(text))}</div>"

object Plaintext:
	def apply(text: String): Plaintext =
		new Plaintext(false)()(text)

	def apply(attributes: Attribute*)(text: String): Plaintext =
		new Plaintext(false)(attributes*)(text)

	def w(attributes: Attribute*)(text: String): Plaintext =
		TagUtils.getWarning("plaintext")(attributes*)
		new Plaintext(true)(attributes*)(text)

	protected final def format(text: StringBuilder): String =
		text.map(
			_ match
				case '\n'  => "<br>"
				case '\t'  => "&emsp"
				case ' '   => "&nbsp"
				case '<'   => "&lt;"
				case '>'   => "&gt;"
				case other => s"$other"
		).mkString("")

	
