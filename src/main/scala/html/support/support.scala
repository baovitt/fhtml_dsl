package fhtml

trait Browser

// List of browsers that this library supports and
// earliest version numbers supported for a tag or attribute.
case class Chrome(
    earliestVersionSupported: String
) extends Browser

case class Edge(
    earliestVersionSupported: String
) extends Browser

case class Firefox(
    earliestVersionSupported: String
) extends Browser

case class Opera(
    earliestVersionSupported: String
) extends Browser

case class Safari(
    earliestVersionSupported: String
) extends Browser

// Array of browsers which contain their level of support for the attribute.
case class AttributeSupport(
    support: scala.collection.immutable.Map[String, (Chrome, Edge, Firefox, Opera, Safari)]
)

// Array of browsers which contain their level of support for the tag.
case class TagSupport(support: (Chrome, Edge, Firefox, Opera, Safari))
