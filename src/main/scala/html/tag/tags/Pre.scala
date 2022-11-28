package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Pre(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<pre ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</pre>"

object Pre:
  def apply(tags: HTMLTag*): Pre =
    new Pre(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Pre =
    new Pre(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Pre =
    TagUtils.getWarning("pre")(attributes*)
    new Pre(true)(attributes*)(tags*)