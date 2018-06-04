package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ListBuffer

/**
  * {{{
  * Given a non-negative integer numRows, generate the first numRows of
  * Pascal's triangle.
  *
  *
  * In Pascal's triangle, each number is the sum of the two numbers
  * directly above it.
  *
  * Example:
  *
  *
  * Input: 5
  * Output:
  * [
  *      [1],
  *     [1,1],
  *    [1,2,1],
  *   [1,3,3,1],
  *  [1,4,6,4,1]
  * ]
  * }}}
  *
  * @see [[https://leetcode.com/problems/pascals-triangle/ PascalsTriangle]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait PascalsTriangle {
  def generate(numRows: Int): List[List[Int]]
}

object PascalsTriangle extends Enumerable[PascalsTriangle] {
  case object Solution extends PascalsTriangle {
    override def generate(numRows: Int): List[List[Int]] =
      numRows match {
        case 0 => Nil
        case _ =>
          val buf = ListBuffer(List(1))
          for (i <- 1 until numRows) {
            val pre = buf(i - 1)
            buf += 1 :: (1 until buf.length).map(i => pre(i) + pre(i - 1)).toList ::: 1 :: Nil
          }
          buf.toList
      }
  }
}
