package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Video(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "4.0"),
    Edge(   "9.0"),
    Firefox("3.5"),
    Opera(  "11.5"),
    Safari( "3.1")
  )

  def getTag: String =
    s"<video ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</video>"

object Video:
  def apply(tags: HTMLTag*): Video =
    new Video(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Video =
    new Video(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Video =
    TagUtils.getWarning("video")(attributes*)
    new Video(true)(attributes*)(tags*)
