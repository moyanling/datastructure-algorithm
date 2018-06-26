package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ListBuffer

/**
  * {{{
  * Given a matrix of m x n elements (m rows, n columns), return all
  * elements of the matrix in spiral order.
  *
  * Example 1:
  *
  *
  * Input:
  * [
  *  [ 1, 2, 3 ],
  *  [ 4, 5, 6 ],
  *  [ 7, 8, 9 ]
  * ]
  * Output: [1,2,3,6,9,8,7,4,5]
  *
  *
  * Example 2:
  *
  * Input:
  * [
  *   [1, 2, 3, 4],
  *   [5, 6, 7, 8],
  *   [9,10,11,12]
  * ]
  * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
  * }}}
  *
  * @see [[https://leetcode.com/problems/spiral-matrix/ SpiralMatrix]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SpiralMatrix {
  def spiralOrder(matrix: Array[Array[Int]]): List[Int]
}

object SpiralMatrix extends Enumerable[SpiralMatrix] {
  case object Solution extends SpiralMatrix {
    override def spiralOrder(matrix: Array[Array[Int]]): List[Int] = {
      var top, left = 0
      var result    = ListBuffer[Int]()
      val m         = matrix.length
      while (top < m / 2 + m % 2 && left < matrix(top).length / 2 + matrix(top).length % 2) {
        val (bottom, right) = (m - top - 1, matrix(top).length - left - 1)
        for (x <- left to right) result += matrix(top)(x)
        for (x <- top + 1 to bottom) result += matrix(x)(right)
        if (bottom != top) for (x <- right - 1 to left by -1) result += matrix(bottom)(x)
        if (left != right) for (x <- bottom - 1 until top by -1) result += matrix(x)(left)
        top += 1
        left += 1
      }
      result.toList
    }
  }
}
