package org.mo39.fmbh.algorithm.twopointers

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given an array of integers that is already sorted in ascending order,
  * find two numbers such that they add up to a specific target number.
  *
  * The function twoSum should return indices of the two numbers such that
  * they add up to the target, where index1 must be less than index2.
  *
  * Note:
  *
  *
  * 	Your returned answers (both index1 and index2) are not zero-based.
  * 	You may assume that each input would have exactly one solution and you
  * may not use the same element twice.
  *
  *
  * Example:
  *
  *
  * Input: numbers = [2,7,11,15], target = 9
  * Output: [1,2]
  * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
  * }}}
  *
  * @see [[https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/ TwoSumIiInputArrayIsSorted]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait TwoSumIiInputArrayIsSorted {
  def twoSum(numbers: Array[Int], target: Int): Array[Int]
}

object TwoSumIiInputArrayIsSorted extends Enumerable[TwoSumIiInputArrayIsSorted] {
  case object Solution extends TwoSumIiInputArrayIsSorted {
    override def twoSum(numbers: Array[Int], target: Int): Array[Int] = {
      var (i, j) = (0, numbers.length - 1)
      while (i < j) {
        val sum = numbers(i) + numbers(j)
        if (sum < target) i += 1
        else if (sum > target) j -= 1
        else return Array(i + 1, j + 1)
      }
      Array.empty
    }
  }
}
