package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Body(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<body ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</body>"

object Body:
	def apply(tags: HTMLTag*): Body =
		new Body(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Body =
		new Body(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Body =
		TagUtils.getWarning("body")(attributes*)
		new Body(true)(attributes*)(tags*)