package org.mo39.fmbh.commons

import org.mo39.fmbh.commons.Const._

object TableOfContent extends App {

  val template: String =
    """
      |# datastructure-algorithms
      |
      |Table of Content:
      |<pre>
      |Algorithm
      | %s
      |Data Structure
      | %s
      |Uncategorized
      | %s
      |</pre>
    """.stripMargin

  private def listProblems(problems: Array[Problem]) =
    problems
      .groupBy(_.category)
      .values
      .map(_.map(p => s"\t- [${p.name}](${p.gitRepoReference})")
        .mkString("\n"))

  listProblems(AlgorithmProblems).foreach(println)

}
