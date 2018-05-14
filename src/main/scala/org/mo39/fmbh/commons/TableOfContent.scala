package org.mo39.fmbh.commons

import java.nio.file.{ Files, Paths }

import com.typesafe.scalalogging.LazyLogging
import org.mo39.fmbh.commons.Const._

object TableOfContent extends App with LazyLogging {

  val template: String =
    s"""
      |# Table of Content
      |
      |### Data Structure
      |%s
      |### Algorithm
      |%s
      |### Uncategorized
      |%s
    """.stripMargin

  private def listProblems(problems: Array[Problem]) =
    problems
      .groupBy(_.category)
      .map(group => s"###### ${group._1}\n${group._2.map(toLink).mkString("\n")}")
      .mkString("\n")

  private val toLink = (p: Problem) => s"  - [${p.name}](${p.gitRepoReference})"

  /* Main Entry */
  logger.info("Start updating README.md")
  val ReadMeContent = template.format(
    listProblems(DatastructureProblems),
    listProblems(AlgorithmProblems),
    UncategorizedProblems.map(toLink).mkString("\n")
  )
  Files.write(ReadMe, ReadMeContent.getBytes)
  logger.info("Done.")
}
