package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Optgroup(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<optgroup ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</optgroup>"

object Optgroup:
  def apply(tags: HTMLTag*): Optgroup =
    new Optgroup(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Optgroup =
    new Optgroup(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Optgroup =
    TagUtils.getWarning("optgroup")(attributes*)
    new Optgroup(true)(attributes*)(tags*)
