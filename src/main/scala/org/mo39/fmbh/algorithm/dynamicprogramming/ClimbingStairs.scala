package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ArrayBuffer

/**
  * {{{
  * You are climbing a stair case. It takes n steps to reach to the top.
  *
  * Each time you can either climb 1 or 2 steps. In how many distinct ways
  * can you climb to the top?
  *
  * Note: Given n will be a positive integer.
  *
  * Example 1:
  *
  *
  * Input: 2
  * Output: 2
  * Explanation: There are two ways to climb to the top.
  * 1. 1 step + 1 step
  * 2. 2 steps
  *
  *
  * Example 2:
  *
  *
  * Input: 3
  * Output: 3
  * Explanation: There are three ways to climb to the top.
  * 1. 1 step + 1 step + 1 step
  * 2. 1 step + 2 steps
  * 3. 2 steps + 1 step
  * }}}
  *
  * @see [[https://leetcode.com/problems/climbing-stairs/ ClimbingStairs]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait ClimbingStairs {
  def climbStairs(n: Int): Int
}

object ClimbingStairs extends Enumerable[ClimbingStairs] {
  case object Solution0 extends ClimbingStairs {
    override def climbStairs(n: Int): Int = {
      if (n < 2) return n
      val memo = ArrayBuffer[Int](1, 1)
      for (i <- 2 to n) {
        memo += memo(i - 2) + memo(i - 1)
      }
      memo.last
    }
  }

  /**
    * Save some spaces
    */
  case object Solution1 extends ClimbingStairs {
    override def climbStairs(n: Int): Int = {
      if (n < 2) return n
      var memo = (1, 1)
      for (_ <- 2 to n) {
        memo = (memo._2, memo._1 + memo._2)
      }
      memo._2
    }
  }
}
