package org.mo39.fmbh.algorithm.bitmanipulation

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given an integer, write a function to determine if it is a power of
  * three.
  *
  * Example 1:
  *
  *
  * Input: 27
  * Output: true
  *
  *
  * Example 2:
  *
  *
  * Input: 0
  * Output: false
  *
  * Example 3:
  *
  *
  * Input: 9
  * Output: true
  *
  * Example 4:
  *
  *
  * Input: 45
  * Output: false
  *
  * Follow up:
  * Could you do it without using any loop / recursion?
  * }}}
  *
  * @see [[https://leetcode.com/problems/power-of-three/ PowerOfThree]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait PowerOfThree {
  def isPowerOfThree(n: Int): Boolean
}

object PowerOfThree extends Enumerable[PowerOfThree] {
  case object Solution extends PowerOfThree {
    override def isPowerOfThree(n: Int): Boolean = n > 0 && 1162261467 % n == 0
  }
}
