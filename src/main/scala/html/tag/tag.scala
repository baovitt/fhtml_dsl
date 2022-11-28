package fhtml

import fhtml.attributes.*

object TagUtils:

  private def getSupport(t: String): fansi.Str = 
    t match
      case "" => fansi.Color.Red("No Support")
      case o => fansi.Color.Green(o)

  def getWarning(tagName: String)(attributes: Attribute*): Unit =
    println(fansi.Color.Green(s"$tagName tag info:"))
    attributes.foreach { attr =>
      println((" "*4) ++ s"\"${attr.getClass.getSimpleName}\" attribute information:")
      if (attr.browserSupport.support.keys.filter(_ == tagName).nonEmpty) 
        val browsers: (Chrome, Edge, Firefox, Opera, Safari) = attr.browserSupport.support(tagName)
        println(
          fansi.Color.Yellow("\n          Earliest Google Chrome Version Support:   ") ++
          getSupport(browsers._1.earliestVersionSupported) ++
          fansi.Color.Yellow("\n          Earliest Microsoft Edge Version Support:  ") ++
          getSupport(browsers._2.earliestVersionSupported) ++
          fansi.Color.Yellow("\n          Earliest Mozilla Firefox Version Support: ") ++
          getSupport(browsers._3.earliestVersionSupported) ++
          fansi.Color.Yellow("\n          Earliest Opera Version Support:           ") ++
          getSupport(browsers._4.earliestVersionSupported) ++
          fansi.Color.Yellow("\n          Earliest Apple Safari Version Support:    ") ++
          getSupport(browsers._5.earliestVersionSupported)
        )
      else if (attr.browserSupport.support.keys.filter(_ == "Global Attributes").nonEmpty)
        val browsers: (Chrome, Edge, Firefox, Opera, Safari) = attr.browserSupport.support("Global Attributes")
        println(
          fansi.Color.Yellow("\n          Earliest Google Chrome Version Support:   ") ++
          getSupport(browsers._1.earliestVersionSupported) ++
          fansi.Color.Yellow("\n          Earliest Microsoft Edge Version Support:  ") ++
          getSupport(browsers._2.earliestVersionSupported) ++
          fansi.Color.Yellow("\n          Earliest Mozilla Firefox Version Support: ") ++
          getSupport(browsers._3.earliestVersionSupported) ++
          fansi.Color.Yellow("\n          Earliest Opera Version Support:           ") ++
          getSupport(browsers._4.earliestVersionSupported) ++
          fansi.Color.Yellow("\n          Earliest Apple Safari Version Support:    ") ++
          getSupport(browsers._5.earliestVersionSupported)
        )
      else
        println(fansi.Color.Red((" "*10) ++ s"The $tagName tag does not support the \"${attr.getClass.getSimpleName}\" attribute\n"))
    }


trait HTMLTag:
  def getTag: String

  val tagSupport: TagSupport



