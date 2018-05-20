package org.mo39.fmbh.commons

import java.io.File
import java.nio.file.{ Files, Path, Paths }

import scala.collection.JavaConversions.propertiesAsScalaMap

object Const {

  val ProjectRoot: Path      = Paths.get(System.getProperties()("user.dir"))
  val ReadMe: Path           = ProjectRoot.resolve(Paths.get("README.md"))
  val ScalaSrcRoot: Path     = Paths.get(ProjectRoot.toString, "src", "main", "scala")
  val JavaSrcRoot: Path      = Paths.get(ProjectRoot.toString, "src", "main", "java")
  val ScalaPackageRoot: Path = Paths.get(ScalaSrcRoot.toString, "org", "mo39", "fmbh")
  val JavaPackageRoot: Path  = Paths.get(JavaSrcRoot.toString, "org", "mo39", "fmbh")
  val ProblemDirs: List[List[Path]] = List(
    Paths.get(ScalaPackageRoot.toString, "algorithm"),
    Paths.get(JavaPackageRoot.toString, "algorithm"),
    Paths.get(ScalaPackageRoot.toString, "datastructure"),
    Paths.get(JavaPackageRoot.toString, "datastructure"),
    Paths.get(ScalaPackageRoot.toString, "uncategorized"),
    Paths.get(JavaPackageRoot.toString, "uncategorized")
  ).grouped(2).toList
  val AlgorithmProblems: List[Problem]     = ProblemDirs(0).flatMap(toProblemArr)
  val DatastructureProblems: List[Problem] = ProblemDirs(1).flatMap(toProblemArr)
  val UncategorizedProblems: List[Problem] = ProblemDirs(2).flatMap(toProblemArr)
  val Problems: List[Problem] = List(
    AlgorithmProblems,
    DatastructureProblems,
    UncategorizedProblems
  ).flatten

  private def toProblemArr(p: Path) =
    Files
      .walk(p)
      .toArray
      .map(f => new File(f.toString))
      .filter(_.isFile)
      .map(Problem)

}
