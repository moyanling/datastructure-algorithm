package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given an array of integers nums, write a method that returns the
  * "pivot" index of this array.
  *
  * We define the pivot index as the index where the sum of the numbers to
  * the left of the index is equal to the sum of the numbers to the right
  * of the index.
  *
  * If no such index exists, we should return -1. If there are multiple
  * pivot indexes, you should return the left-most pivot index.
  *
  *
  * Example 1:
  *
  * Input:
  * nums = [1, 7, 3, 6, 5, 6]
  * Output: 3
  * Explanation:
  * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to
  * the sum of numbers to the right of index 3.
  * Also, 3 is the first index where this occurs.
  *
  *
  *
  * Example 2:
  *
  * Input:
  * nums = [1, 2, 3]
  * Output: -1
  * Explanation:
  * There is no index that satisfies the conditions in the problem
  * statement.
  *
  *
  *
  * Note:
  * The length of nums will be in the range [0, 10000].
  * Each element nums[i] will be an integer in the range [-1000, 1000].
  * }}}
  *
  * @see [[https://leetcode.com/problems/find-pivot-index/ FindPivotIndex]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait FindPivotIndex {
  def pivotIndex(nums: Array[Int]): Int
}

object FindPivotIndex extends Enumerable[FindPivotIndex] {
  case object Solution extends FindPivotIndex {
    override def pivotIndex(nums: Array[Int]): Int = {
      var (s, sum) = (0, nums.sum)
      for (i <- nums.indices) {
        if (sum - nums(i) == s * 2) return i
        else s += nums(i)
      }
      -1
    }
  }
}
