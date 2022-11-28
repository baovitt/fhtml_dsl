package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Meta(showWarning: Boolean)(var attributes: Attribute*) extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<meta ${this.attributes.map(_.getAttribute).mkString(" ")}>"

object Meta:

  def apply(attributes: Attribute*): Meta =
    new Meta(false)(attributes*)

  def w(attributes: Attribute*): Meta =
    TagUtils.getWarning("meta")(attributes*)
    new Meta(true)(attributes*)