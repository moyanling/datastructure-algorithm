package org.mo39.fmbh.algorithm.bitmanipulation

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai
  * < 231.
  *
  * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
  *
  * Could you do this in O(n) runtime?
  *
  * Example:
  *
  * Input: [3, 10, 5, 25, 2, 8]
  *
  * Output: 28
  *
  * Explanation: The maximum result is 5 ^ 25 = 28.
  * }}}
  *
  * @see [[https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/ MaximumXorOfTwoNumbersInAnArray]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MaximumXorOfTwoNumbersInAnArray {
  def findMaximumXOR(nums: Array[Int]): Int
}

object MaximumXorOfTwoNumbersInAnArray extends Enumerable[MaximumXorOfTwoNumbersInAnArray] {
  case object Solution extends MaximumXorOfTwoNumbersInAnArray {
    override def findMaximumXOR(nums: Array[Int]): Int = ???
  }

}
