package org.mo39.fmbh.commons.utils

import java.io.File
import java.nio.file.{Files, Path, Paths}
import scala.collection.JavaConversions.propertiesAsScalaMap

object Const {

  val ProjectRoot: Path = Paths.get(System.getProperties()("user.dir"))
  val SrcRoot: Path = Paths.get(ProjectRoot.toString, "src", "main", "scala")
  val PackageRoot: Path = Paths.get(SrcRoot.toString, "org", "mo39", "fmbh")
  val ProblemDirs: List[Path] = List(
    Paths.get(PackageRoot.toString, "algorithm"),
    Paths.get(PackageRoot.toString, "datastructure"),
    Paths.get(PackageRoot.toString, "uncategorized")
  )
  val Problems: List[Path] = ProblemDirs
    .flatMap(Files.walk(_).toArray)
    .map(f => new File(f.toString))
    .filter(_.isFile)
    .map(_.toPath)

}
