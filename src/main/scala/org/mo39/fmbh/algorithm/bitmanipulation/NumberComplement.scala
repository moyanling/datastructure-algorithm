package org.mo39.fmbh.algorithm.bitmanipulation

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  *
  * {{{
  * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
  *
  * Note:
  *
  * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
  * You could assume no leading zero bit in the integer’s binary representation.
  *
  *
  *
  * Example 1:
  *
  * Input: 5
  * Output: 2
  * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
  *
  *
  *
  * Example 2:
  *
  * Input: 1
  * Output: 0
  * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
  *
  *
  * }}}
  *
  * "@see [[https://leetcode.com/problems/number-complement/ Number Complement]]"
  * "@author mo39.fmbh"
  */
@ProblemSource(LeetCode)
sealed trait NumberComplement {
  def findComplement(num: Int): Int
}

object NumberComplement extends Enumerable[NumberComplement] {

  /* Parse the binary string with a radix */
  case object Solution0 extends NumberComplement {
    def findComplement(num: Int): Int =
      Integer.parseInt(
        num.toBinaryString.map(i => if (i == '1') '0' else '1'),
        2
      )
  }

  case object Solution1 extends NumberComplement {
    def findComplement(num: Int): Int = ???
  }

}
