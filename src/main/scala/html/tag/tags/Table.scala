package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Table(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<table ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</table>"

object Table:
  def apply(tags: HTMLTag*): Table =
    new Table(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Table =
    new Table(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Table =
    TagUtils.getWarning("table")(attributes*)
    new Table(true)(attributes*)(tags*)
