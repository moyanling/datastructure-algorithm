package org.mo39.fmbh.commons

import java.io.File
import java.nio.file.Paths

import org.apache.commons.io.FilenameUtils._
import org.mo39.fmbh.commons.Const._

import scala.io.Source

/* Case class presenting a Problem */
case class Problem(file: File) {

  require(file.isFile)

  /* Parse the file name of the problem to the actual name */
  val name: String = removeExtension(file.getName)

  /* Read the content of the file */
  lazy val content: Iterator[String] = Source.fromFile(file).getLines

  val isScala: Boolean = getExtension(file.getName) == "scala"
  val isJava: Boolean  = getExtension(file.getName) == "java"

  /* Gives a category of the problem */
  val category: String = {
    val packageRoot = if (isJava) JavaPackageRoot else ScalaPackageRoot
    packageRoot
      .relativize(Paths.get(file.getParent))
      .getFileName
      .toString
  }

  /* Gives the git repository reference */
  val gitRepoReference: String =
  "../master/" +
  ProjectRoot
    .relativize(file.toPath)
    .toString
    .replace(File.separator, "/")

  override def toString: String = name

}
