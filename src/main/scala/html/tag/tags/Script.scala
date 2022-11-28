package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Script(showWarning: Boolean)(var attributes: Attribute*)(js: String)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "All"),
    Edge(   "All"),
    Firefox("All"),
    Opera(  "All"),
    Safari( "All")
  )

  def getTag: String =
    s"<script ${attributes.map(_.getAttribute).mkString(" ")}>${js}</script>"

object Script:
  def apply(js: String): Script =
    new Script(false)()(js)

  def apply(attributes: Attribute*)(js: String): Script =
    new Script(false)(attributes*)(js)

  def w(attributes: Attribute*)(js: String): Script =
    TagUtils.getWarning("script")(attributes*)
    new Script(true)(attributes*)(js)

