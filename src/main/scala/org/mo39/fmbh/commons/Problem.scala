package org.mo39.fmbh.commons

import java.io.File
import java.nio.file.Paths

import org.apache.commons.io.FilenameUtils.removeExtension
import org.mo39.fmbh.commons.Const._

import scala.io.Source

/* Case class presenting a Problem */
case class Problem(file: File) {

  require(file.isFile)

  /* Parse the file name of the problem to the actual name */
  val name: String = removeExtension(file.getName)

  /* Read the content of the file */
  lazy val content: Iterator[String] = Source.fromFile(file).getLines

  /* Gives a category of the problem */
  val category: String =
    PackageRoot
      .relativize(Paths.get(file.getParent))
      .getFileName
      .toString

  /* Gives the git repository reference */
  val gitRepoReference: String =
    "../master/" +
      ProjectRoot
        .relativize(file.toPath)
        .toString
        .replace(File.separator, "/")

  override def toString: String = name

}
