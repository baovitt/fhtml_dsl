package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Style(showWarning: Boolean)(var attributes: Attribute*)(css: String)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<style ${attributes.map(_.getAttribute).mkString(" ")}>${css}</style>"

object Style:
  def apply(css: String): Style =
    new Style(false)()(css)

  def apply(attributes: Attribute*)(css: String): Style =
    new Style(false)(attributes*)(css)

  def w(attributes: Attribute*)(css: String): Style =
    TagUtils.getWarning("style")(attributes*)
    new Style(true)(attributes*)(css)
