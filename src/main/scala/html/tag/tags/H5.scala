package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class H5(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<h5 ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</h5>"

object H5:
	def apply(tags: HTMLTag*): H5 =
		new H5(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): H5 =
		new H5(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): H5 =
		TagUtils.getWarning("h5")(attributes*)
		new H5(true)(attributes*)(tags*)