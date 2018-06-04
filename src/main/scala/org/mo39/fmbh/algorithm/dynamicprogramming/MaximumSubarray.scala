package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ArrayBuffer

/**
  * {{{
  * Given an integer array nums, find the contiguous subarray (containing
  * at least one number) which has the largest sum and return its sum.
  *
  * Example:
  *
  *
  * Input: [-2,1,-3,4,-1,2,1,-5,4],
  * Output: 6
  * Explanation: [4,-1,2,1] has the largest sum = 6.
  *
  *
  * Follow up:
  *
  * If you have figured out the O(n) solution, try coding another solution
  * using the divide and conquer approach, which is more subtle.
  * }}}
  *
  * @see [[https://leetcode.com/problems/maximum-subarray/ MaximumSubarray]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MaximumSubarray {
  def maxSubArray(nums: Array[Int]): Int
}

object MaximumSubarray extends Enumerable[MaximumSubarray] {

  /**
    * For the number at a certain index, there are two states.
    * 1. The sub array contain this number
    * 2. The sub array does not contain this number
    */
  case object Solution0 extends MaximumSubarray {
    override def maxSubArray(nums: Array[Int]): Int = {
      val memo = ArrayBuffer(Int.MinValue)
      for (i <- nums.indices) {
        memo += (if (memo(i) < 0) nums(i) else memo(i) + nums(i))
      }
      memo.max
    }
  }

  /** Follow up */
  case object Solution1 extends MaximumSubarray {
    override def maxSubArray(nums: Array[Int]): Int = ???
  }
}
