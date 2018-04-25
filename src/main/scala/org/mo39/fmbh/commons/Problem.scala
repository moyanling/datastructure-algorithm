package org.mo39.fmbh.commons

import java.io.File

import org.apache.commons.io.FilenameUtils.removeExtension

import scala.collection.IndexedSeqLike
import scala.collection.mutable.Builder
import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/* Case class presenting a Problem */
case class Problem(file: File) {

  require(file.isFile)

  /* Parse the file name of the problem to the actual name */
  val name: String = removeExtension(file.getName)

  /* Read the content of the file */
  lazy val content: Iterator[String] = Source.fromFile(file).getLines

  val category: String = file.getParent

  override def toString: String = name

}

/**
  * Sequence of problems collection
  *
  * @param buffer A Problem ArrayBuffer
  */
final class ProblemSeq(private val buffer: ArrayBuffer[Problem],
                       val length: Int)
    extends IndexedSeq[Problem]
    with IndexedSeqLike[Problem, ProblemSeq] {

  def apply(index: Int): Problem = {
    if (index < 0 || length <= index) throw new IndexOutOfBoundsException
    buffer(index)
  }

  /* Builder method to build the result of methods like Filter */
  override protected[this] def newBuilder: Builder[Problem, ProblemSeq] = {
    new ArrayBuffer[Problem].mapResult(arr => new ProblemSeq(arr, arr.length))
  }

}

object ProblemSeq {
  def apply(problems: Problem*): ProblemSeq = {
    new ProblemSeq(problems.to[ArrayBuffer], problems.length)
  }
}
