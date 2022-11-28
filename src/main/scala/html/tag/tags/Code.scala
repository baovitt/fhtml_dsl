package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Code(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<code ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</code>"

object Code:
	def apply(tags: HTMLTag*): Code =
		new Code(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Code =
		new Code(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Code =
		TagUtils.getWarning("code")(attributes*)
		new Code(true)(attributes*)(tags*)