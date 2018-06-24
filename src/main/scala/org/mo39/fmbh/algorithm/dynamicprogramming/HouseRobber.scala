package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * You are a professional robber planning to rob houses along a street.
  * Each house has a certain amount of money stashed, the only constraint
  * stopping you from robbing each of them is that adjacent houses have
  * security system connected and it will automatically contact the police
  * if two adjacent houses were broken into on the same night.
  *
  * Given a list of non-negative integers representing the amount of money
  * of each house, determine the maximum amount of money you can rob
  * tonight without alerting the police.
  *
  * Example 1:
  *
  *
  * Input: [1,2,3,1]
  * Output: 4
  * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
  *              Total amount you can rob = 1 + 3 = 4.
  *
  * Example 2:
  *
  *
  * Input: [2,7,9,3,1]
  * Output: 12
  * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob
  * house 5 (money = 1).
  *              Total amount you can rob = 2 + 9 + 1 = 12.
  * }}}
  *
  * @see [[https://leetcode.com/problems/house-robber/ HouseRobber]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait HouseRobber {
  def rob(nums: Array[Int]): Int
}

object HouseRobber extends Enumerable[HouseRobber] {

  /**
    * Had to do a tmp because scala can't do {{{(a, b) = (math.max(b + n, a), a)}}}
    */
  case object Solution extends HouseRobber {
    override def rob(nums: Array[Int]): Int = {
      var (a, b) = (0, 0)
      for (n <- nums) {
        val tmp = b
        b = a
        a = math.max(tmp + n, a)
      }
      math.max(a, b)
    }
  }
}
