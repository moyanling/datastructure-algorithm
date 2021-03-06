package org.mo39.fmbh.commons

import com.typesafe.scalalogging.LazyLogging
import org.apache.commons.text.StringEscapeUtils.unescapeHtml4
import org.jsoup.Jsoup
import org.mo39.fmbh.commons.Const._
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Z.toStrWrapper

import scala.util.Try

/**
  * Get the LeetDoc description to the clipboard with the signature.
  *
  * The pre-requisite are:
  * 1. Trait
  * 2. Marked with [[org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode]]
  * 3. Only one trait matches above items and does not yet have a comment
  */
object LeetDoc extends App with LazyLogging {

  val scalaTemplate =
    s"""{{{
       |%s
       |}}}
       |
       |@see [[%s %s]]
       |@author mo39.fmbh""".stripMargin

  val javaTemplate =
    s"""<pre>
       |{@code
       |%s
       |}
       |</pre>
       |
       |@see <a href=%s>%s</a>
       |@author mo39.fmbh""".stripMargin

  /**
    * Some requirements are:
    * 1. Comment ending should not lies before the annotation
    * 2. The annotation must be followed by a sealed trait for Scala or a public enum for Java
    */
  val regex = s".*(?<!\\*\\/)@ProblemSource\\($LeetCode\\)((sealed trait)|(public enum)).*"
  val list  = Problems.filter(_.content.mkString.matches(regex))

  /* Given a problem name, generate the LeetCode link */
  def linkOf(name: String): String = {
    val linkName = name match {
      case "OneBitAndTwoBitCharacters" => "1-bit-and-2-bit-characters"
      case _ =>
        val charArr  = name.toCharArray
        val charList = new StringBuilder()
        for (i <- charArr.indices) {
          if (i != 0 && charArr(i).isUpper
              && (charArr(i - 1) != 'I'
              || i < charArr.length - 1 && charArr(i + 1).isLower)
              || !charArr(i).isLetter) charList.append('-')
          charList.append(charArr(i).toLower)
        }
        charList.toString
    }
    s"https://leetcode.com/problems/$linkName/"
  }

  /* Fetch the description of the problem */
  private def fetchDesc(link: String): String = {
    val desc = Try {
      val desc = Jsoup
        .connect(link)
        /* 403 forbidden if no user agent */
        .userAgent("Chrome/33.0.1750.152")
        .get
        .select("meta[name=description]")
        .first()
        .attr("content")
      /* Some problems need Premium access */
      if (desc.contains("Level up your coding skills")) ""
      else desc
    }.getOrElse("")
    /* Format the description to limit its width */
    unescapeHtml4(desc).split('\n').flatMap(_.limitWidthTo(70)).mkString("\n")
  }

  /* Main entry */
  logger.info("Starting...")

  /* Format the LeetDoc */
  private def format(str: String) = {
    val content = str.split('\n').map(s => s" * $s").toList
    ("\n/**" :: content ::: " */" :: Nil).mkString("\n")
  }

  if (list.isEmpty) logger.error("Found nothing.")
  else if (list.length > 1) logger.error(s"Found ${list.map(_.name)}.")
  else {
    val name = list.head.name
    logger.info(s"Found '$name'.")
    val link = linkOf(name)
    logger.info(s"Fetching $link")
    val desc = fetchDesc(link)
    if (desc != "") logger.info("Success.")
    else logger.info("╮(╯_╰)╭")
    val leetDoc =
      if (list.head.isScala) scalaTemplate.format(desc, link, name)
      else javaTemplate.format(desc, link, name)
    logger.info("Copying the LeetDoc to the clipboard.")
    format(leetDoc).toClipboard
  }
  logger.info("Done.")

}
