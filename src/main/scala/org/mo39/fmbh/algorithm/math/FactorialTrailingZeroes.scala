package org.mo39.fmbh.algorithm.math

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given an integer n, return the number of trailing zeroes in n!.
  *
  * Example 1:
  *
  *
  * Input: 3
  * Output: 0
  * Explanation: 3! = 6, no trailing zero.
  *
  * Example 2:
  *
  *
  * Input: 5
  * Output: 1
  * Explanation: 5! = 120, one trailing zero.
  *
  * Note: Your solution should be in logarithmic time complexity.
  * }}}
  *
  * @see [[https://leetcode.com/problems/factorial-trailing-zeroes/ FactorialTrailingZeroes]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait FactorialTrailingZeroes {
  def trailingZeroes(n: Int): Int
}

object FactorialTrailingZeroes extends Enumerable[FactorialTrailingZeroes] {
  case object Solution extends FactorialTrailingZeroes {
    override def trailingZeroes(n: Int): Int = ???
  }
}
