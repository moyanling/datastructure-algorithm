package org.mo39.fmbh.commons

import java.nio.file.{Files, Paths}

import org.mo39.fmbh.commons.Const._

object TableOfContent extends App {

  val template: String =
    s"""
      |# datastructure-algorithms
      |
      |## Table of Content:
      |##### Data Structure
      |%s
      |
      |##### Algorithm
      |%s
      |
      |##### Uncategorized
      |%s
    """.stripMargin

  private def listProblems(problems: Array[Problem]) =
    problems
      .groupBy(_.category)
      .map(group =>
        s"######${group._1}\n${group._2.map(toLink).mkString("\n")}")
      .mkString("\n")

  private val toLink = (p: Problem) => s"- [${p.name}](${p.gitRepoReference})"

  val ReadMeContent = template.format(
    listProblems(DatastructureProblems),
    listProblems(AlgorithmProblems),
    UncategorizedProblems.map(toLink).mkString("\n")
  )
  Files.write(ReadMe, ReadMeContent.getBytes)
}
