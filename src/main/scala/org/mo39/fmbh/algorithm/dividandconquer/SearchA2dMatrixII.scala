package org.mo39.fmbh.algorithm.dividandconquer

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Write an efficient algorithm that searches for a value in an m x n
  * matrix. This matrix has the following properties:
  *
  *
  * 	Integers in each row are sorted in ascending from left to right.
  * 	Integers in each column are sorted in ascending from top to bottom.
  *
  *
  * Example:
  *
  * Consider the following matrix:
  *
  *
  * [
  *   [1,   4,  7, 11, 15],
  *   [2,   5,  8, 12, 19],
  *   [3,   6,  9, 16, 22],
  *   [10, 13, 14, 17, 24],
  *   [18, 21, 23, 26, 30]
  * ]
  *
  *
  * Given target = 5, return true.
  *
  * Given target = 20, return false.
  * }}}
  *
  * @see [[https://leetcode.com/problems/search-a-2d-matrix-ii/ SearchA2dMatrixII]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SearchA2dMatrixII {
  def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean
}

object SearchA2dMatrixII extends Enumerable[SearchA2dMatrixII] {
  case object Solution extends SearchA2dMatrixII {
    override def searchMatrix(matrix: Array[Array[Int]], target: Int): Boolean = ???
  }
}
