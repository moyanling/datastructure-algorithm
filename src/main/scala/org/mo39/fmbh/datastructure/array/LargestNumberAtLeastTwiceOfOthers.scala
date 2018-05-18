package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * In a given integer array nums, there is always exactly one largest
  * element.
  *
  * Find whether the largest element in the array is at least twice as much
  * as every other number in the array.
  *
  * If it is, return the index of the largest element, otherwise return -1.
  *
  * Example 1:
  *
  * Input: nums = [3, 6, 1, 0]
  * Output: 1
  * Explanation: 6 is the largest integer, and for every other number in
  * the array x,
  * 6 is more than twice as big as x.  The index of value 6 is 1, so we
  * return 1.
  *
  * Example 2:
  *
  * Input: nums = [1, 2, 3, 4]
  * Output: -1
  * Explanation: 4 isn't at least as big as twice the value of 3, so we
  * return -1.
  *
  * Note:
  *
  *
  * 	nums will have a length in the range [1, 50].
  * 	Every nums[i] will be an integer in the range [0, 99].
  *
  * }}}
  *
  * @see [[https://leetcode.com/problems/largest-number-at-least-twice-of-others/ LargestNumberAtLeastTwiceOfOthers]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait LargestNumberAtLeastTwiceOfOthers {
  def dominantIndex(nums: Array[Int]): Int
}

object LargestNumberAtLeastTwiceOfOthers extends Enumerable[LargestNumberAtLeastTwiceOfOthers] {
  case object Solution extends LargestNumberAtLeastTwiceOfOthers {
    def dominantIndex(nums: Array[Int]): Int = {
      val max = nums.max
      if (nums.forall(n => n == max || max >= n * 2)) nums.indexOf(max)
      else -1
    }
  }
}
