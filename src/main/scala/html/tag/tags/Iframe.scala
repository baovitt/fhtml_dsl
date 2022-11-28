package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Iframe(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<iframe ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</iframe>"

object Iframe:
	def apply(tags: HTMLTag*): Iframe =
		new Iframe(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Iframe =
		new Iframe(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Iframe =
		TagUtils.getWarning("iframe")(attributes*)
		new Iframe(true)(attributes*)(tags*)