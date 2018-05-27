package org.mo39.fmbh.algorithm.twopointers

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  *
  * Given an unsorted array of integers, find the length of longest
  * continuous increasing subsequence (subarray).
  *
  *
  * Example 1:
  *
  * Input: [1,3,5,4,7]
  * Output: 3
  * Explanation: The longest continuous increasing subsequence is [1,3,5],
  * its length is 3.
  * Even though [1,3,5,7] is also an increasing subsequence, it's not a
  * continuous one where 5 and 7 are separated by 4.
  *
  *
  *
  * Example 2:
  *
  * Input: [2,2,2,2,2]
  * Output: 1
  * Explanation: The longest continuous increasing subsequence is [2], its
  * length is 1.
  *
  *
  *
  * Note:
  * Length of the array will not exceed 10,000.
  * }}}
  *
  * @see [[https://leetcode.com/problems/longest-continuous-increasing-subsequence/ LongestContinuousIncreasingSubsequence]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait LongestContinuousIncreasingSubsequence {
  def findLengthOfLCIS(nums: Array[Int]): Int
}

object LongestContinuousIncreasingSubsequence extends Enumerable[LongestContinuousIncreasingSubsequence] {
  case object Solution extends LongestContinuousIncreasingSubsequence {
    override def findLengthOfLCIS(nums: Array[Int]): Int = {
      if (nums.length < 2) return nums.length
      var (i, max) = (0, 0)
      for (j <- 1 to nums.length if j == nums.length || nums(j) <= nums(j - 1)) {
        max = math.max(j - i, max)
        i = j
      }
      max
    }
  }
}
