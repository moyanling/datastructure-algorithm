package org.mo39.fmbh.commons.utils

import java.io.File
import java.nio.file.{Files, Paths}

import com.typesafe.scalalogging.LazyLogging
import org.jsoup.Jsoup
import org.mo39.fmbh.commons.utils.Const._
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Z.toStrWrapper

import scala.io.Source
import scala.util.Try

/**
  * Get the LeetDoc description to the clipboard with the signature.
  *
  * The pre-requisite are:
  * 1. Trait
  * 2. Marked with [[org.mo39.fmbh.commons.annotations.SourceValue.LeetCode]]
  * 3. Only one trait matches above items and does not yet have a comment
  */
object LeetDoc extends App with LazyLogging {

  val template =
    s"""
     |{{{
     |%s
     |}}}
     |
     |"@see [[%s %s]]"
     |"@author mo39.fmbh"
     """.stripMargin

  /* Parse the file name of the problem to the actual name */
  def nameOf(problem: String): String =
    problem
      .split(s"\\${File.separator}")
      .last
      .stripSuffix(".scala")

  /* Given a problem name, generate the LeetCode link */
  def linkOf(name: String): String = {
    val linkName = name match {
      case "OneBitAndTwoBitCharacters" => "1-bit-and-2-bit-characters"
      case _ =>
        val charArr = name.toCharArray
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
  def fetchDesc(link: String): String = {
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
      if (desc.contains("LeetCode Online Judge is a platform")) ""
      else desc
    }.getOrElse("")
    /* Format the description to limit its width */
    val width = 70
    desc
      .split('\n')
      .flatMap(line => {
        if (line.length < width) List(line)
        else {
          val charArr = line.toCharArray
          var len = 0
          for (i <- line.indices) {
            if (charArr(i).isSpaceChar && len >= width) {
              charArr.update(i, '\n')
              len = 0
            } else len += 1
          }
          charArr.mkString.split('\n')
        }
      })
      .mkString("\n")
  }

  /**
    * Try find the only candidate annotated by
    * [[org.mo39.fmbh.commons.annotations.SourceValue.LeetCode]]
    * that does not yet have a comment
    */
  def findProblems: List[String] = {
    ProblemDirs
      .flatMap(Files.walk(_).toArray)
      .map(_.toString)
      .filter(Paths.get(_).toFile.isFile)
      .filter(
        Source
          .fromFile(_)
          .getLines
          .mkString
          /* Simply use Zero-Length assertion and the annotation literal to match the file content */
          .matches(s".*(?<!\\*\\/)@ProblemSource\\($LeetCode\\).*")
      )
  }

  /* Main entry */
  logger.info("Starting...")
  val list = findProblems
  if (list.isEmpty) logger.error("Found nothing.")
  else if (list.length > 1) logger.error(s"Found ${list.map(nameOf)}.")
  else {
    val name = nameOf(list.head)
    logger.info(s"Found '$name'.")
    val link = linkOf(name)
    logger.info(s"Fetching $link")
    val desc = fetchDesc(link)
    if (desc != "") logger.info("Success.")
    val leetDoc = template.format(desc, link, name)
    logger.info("Copying the LeetDoc to the clipboard.")
    leetDoc.toClipboard
  }
  logger.info("Done.")

}
