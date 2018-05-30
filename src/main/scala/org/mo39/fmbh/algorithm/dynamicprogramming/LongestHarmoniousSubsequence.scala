package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ArrayBuffer

/**
  * {{{
  * We define a harmonious array is an array where the difference between
  * its maximum value and its minimum value is exactly 1.
  *
  * Now, given an integer array, you need to find the length of its longest
  * harmonious subsequence among all its possible subsequences.
  *
  * Example 1:
  *
  * Input: [1,3,2,2,5,2,3,7]
  * Output: 5
  * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
  *
  *
  *
  * Note:
  * The length of the input array will not exceed 20,000.
  * }}}
  *
  * @see [[https://leetcode.com/problems/longest-harmonious-subsequence/ LongestHarmoniousSubsequence]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait LongestHarmoniousSubsequence {
  def findLHS(nums: Array[Int]): Int
}

object LongestHarmoniousSubsequence extends Enumerable[LongestHarmoniousSubsequence] {

  /**
    * The state of the result depends on two states of all previous sub results.
    * And all previous sub results can be hash.
    */
  case object Solution extends LongestHarmoniousSubsequence {
    override def findLHS(nums: Array[Int]): Int = {
      val memo = ArrayBuffer[(Int, Int)]()
      ???
    }
  }

}
