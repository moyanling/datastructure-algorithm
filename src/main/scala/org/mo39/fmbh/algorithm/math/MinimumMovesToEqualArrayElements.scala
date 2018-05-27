package org.mo39.fmbh.algorithm.math

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a non-empty integer array of size n, find the minimum number of
  * moves required to make all array elements equal, where a move is
  * incrementing n - 1 elements by 1.
  *
  * Example:
  *
  * Input:
  * [1,2,3]
  *
  * Output:
  * 3
  *
  * Explanation:
  * Only three moves are needed (remember each move increments two
  * elements):
  *
  * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
  * }}}
  *
  * @see [[https://leetcode.com/problems/minimum-moves-to-equal-array-elements/ MinimumMovesToEqualArrayElements]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MinimumMovesToEqualArrayElements {
  def minMoves(nums: Array[Int]): Int
}

object MinimumMovesToEqualArrayElements extends Enumerable[MinimumMovesToEqualArrayElements] {
  case object Solution extends MinimumMovesToEqualArrayElements {
    override def minMoves(nums: Array[Int]): Int = nums.map(_ - nums.min).sum
  }
}
