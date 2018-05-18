package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given an m * n matrix M initialized with all 0's and several update
  * operations.
  * Operations are represented by a 2D array, and each operation is
  * represented by an array with two positive integers a and b, which means
  * M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.
  * You need to count and return the number of maximum integers in the
  * matrix after performing all the operations.
  *
  * Example 1:
  *
  * Input:
  * m = 3, n = 3
  * operations = [[2,2],[3,3]]
  * Output: 4
  * Explanation:
  * Initially, M =
  * [[0, 0, 0],
  *  [0, 0, 0],
  *  [0, 0, 0]]
  *
  * After performing [2,2], M =
  * [[1, 1, 0],
  *  [1, 1, 0],
  *  [0, 0, 0]]
  *
  * After performing [3,3], M =
  * [[2, 2, 1],
  *  [2, 2, 1],
  *  [1, 1, 1]]
  *
  * So the maximum integer in M is 2, and there are four of it in M. So
  * return 4.
  *
  *
  *
  * Note:
  *
  * The range of m and n is [1,40000].
  * The range of a is [1,m], and the range of b is [1,n].
  * The range of operations size won't exceed 10,000.
  * }}}
  *
  * @see [[https://leetcode.com/problems/range-addition-ii/ RangeAdditionII]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait RangeAdditionII {
  def maxCount(m: Int, n: Int, ops: Array[Array[Int]]): Int
}

object RangeAdditionII extends Enumerable[RangeAdditionII] {
  case object Solution extends RangeAdditionII {
    override def maxCount(m: Int, n: Int, ops: Array[Array[Int]]): Int = {
      if (ops.length == 0) return m * n
      val min = (i: Int) => ops.minBy(_(i)).apply(i)
      min(0) * min(1)
    }
  }
}
