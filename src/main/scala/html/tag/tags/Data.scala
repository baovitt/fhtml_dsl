package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Data(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "62.0"),
    Edge(   "13.0"),
    Firefox("22.0"),
    Opera(  "49.0"),
    Safari( "")
  )

  def getTag: String =
    s"<data ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</data>"

object Data:
	def apply(tags: HTMLTag*): Data =
		new Data(false)()(tags*)

	def apply(attributes: Attribute*)(tags: HTMLTag*): Data =
		new Data(false)(attributes*)(tags*)

	def w(attributes: Attribute*)(tags: HTMLTag*): Data =
		TagUtils.getWarning("data")(attributes*)
		new Data(true)(attributes*)(tags*)