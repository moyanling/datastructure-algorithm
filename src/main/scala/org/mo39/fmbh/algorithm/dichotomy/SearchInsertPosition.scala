package org.mo39.fmbh.algorithm.dichotomy

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a sorted array and a target value, return the index if the target
  * is found. If not, return the index where it would be if it were
  * inserted in order.
  *
  * You may assume no duplicates in the array.
  *
  * Example 1:
  *
  *
  * Input: [1,3,5,6], 5
  * Output: 2
  *
  *
  * Example 2:
  *
  *
  * Input: [1,3,5,6], 2
  * Output: 1
  *
  *
  * Example 3:
  *
  *
  * Input: [1,3,5,6], 7
  * Output: 4
  *
  *
  * Example 4:
  *
  *
  * Input: [1,3,5,6], 0
  * Output: 0
  * }}}
  *
  * @see [[https://leetcode.com/problems/search-insert-position/ SearchInsertPosition]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SearchInsertPosition {
  def searchInsert(nums: Array[Int], target: Int): Int
}

object SearchInsertPosition extends Enumerable[SearchInsertPosition] {
  case object Solution extends SearchInsertPosition {
    override def searchInsert(nums: Array[Int], target: Int): Int = {
      var (i, j) = (0, nums.length - 1)
      while (i < j) {
        val mid = (i + j) / 2
        if (nums(mid) == target) return mid
        else if (nums(mid) > target) j = mid
        else i = mid + 1
      }
      if (nums(i) < target) i + 1 else i // Pointer i cannot go beyond index so this has to be done manually.
    }
  }
}
