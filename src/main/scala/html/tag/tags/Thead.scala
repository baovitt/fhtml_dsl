package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Thead(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<thead ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</thead>"

object Thead:
  def apply(tags: HTMLTag*): Thead =
    new Thead(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Thead =
    new Thead(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Thead =
    TagUtils.getWarning("thead")(attributes*)
    new Thead(true)(attributes*)(tags*)
