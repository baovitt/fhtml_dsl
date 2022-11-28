package fhtml

import fhtml.attributes.*

@scala.annotation.varargs
class Template(showWarning: Boolean)(var attributes: Attribute*)(tags: HTMLTag*)
    extends HTMLTag:

  val tagSupport: TagSupport = TagSupport(
    Chrome( "26.0"),
    Edge(   "13.0"),
    Firefox("22.0"),
    Opera(  "15.0"),
    Safari( "8.0")
  )

  def getTag: String =
    s"<template ${attributes.map(_.getAttribute).mkString(" ")}>${tags.map(_.getTag).mkString}</template>"

object Template:
  def apply(tags: HTMLTag*): Template =
    new Template(false)()(tags*)

  def apply(attributes: Attribute*)(tags: HTMLTag*): Template =
    new Template(false)(attributes*)(tags*)

  def w(attributes: Attribute*)(tags: HTMLTag*): Template =
    TagUtils.getWarning("template")(attributes*)
    new Template(true)(attributes*)(tags*)
