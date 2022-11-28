package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Fieldset(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<fieldset ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</fieldset>"

object Fieldset:
	def apply(tags: HTMLTag*): Fieldset =
		new Fieldset(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Fieldset =
		new Fieldset(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Fieldset =
		TagUtils.getWarning("fieldset")(attributes*)
		new Fieldset(true)(attributes*)(tags*)