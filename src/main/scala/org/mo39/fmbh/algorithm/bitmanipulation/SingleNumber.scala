package org.mo39.fmbh.algorithm.bitmanipulation

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a non-empty&nbsp;array of integers, every element appears twice except for one. Find that single one.
  *
  * Note:
  *
  * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
  *
  * Example 1:
  *
  *
  * Input: [2,2,1]
  * Output: 1
  *
  *
  * Example 2:
  *
  *
  * Input: [4,1,2,1,2]
  * Output: 4
  *
  *
  * }}}
  *
  * @see [[https://leetcode.com/problems/single-number/ Single Number]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SingleNumber {
  def singleNumber(nums: Array[Int]): Int
}

object SingleNumber extends Enumerable[SingleNumber] {

  case object Solution extends SingleNumber {
    override def singleNumber(nums: Array[Int]): Int = nums.reduce(_ ^ _)
  }

}
