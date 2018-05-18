package org.mo39.fmbh.algorithm.bitmanipulation

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a positive integer, check whether it has alternating bits: namely, if two adjacent bits will always have different values.
  *
  * Example 1:
  *
  * Input: 5
  * Output: True
  * Explanation:
  * The binary representation of 5 is: 101
  *
  *
  *
  * Example 2:
  *
  * Input: 7
  * Output: False
  * Explanation:
  * The binary representation of 7 is: 111.
  *
  *
  *
  * Example 3:
  *
  * Input: 11
  * Output: False
  * Explanation:
  * The binary representation of 11 is: 1011.
  *
  *
  *
  * Example 4:
  *
  * Input: 10
  * Output: True
  * Explanation:
  * The binary representation of 10 is: 1010.
  *
  *
  * }}}
  *
  * @see [[https://leetcode.com/problems/binary-number-with-alternating-bits/ Binary Number With Alternating Bits]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait BinaryNumberWithAlternatingBits {
  def hasAlternatingBits(n: Int): Boolean
}

object BinaryNumberWithAlternatingBits extends Enumerable[BinaryNumberWithAlternatingBits] {

  /* Regex */
  case object Solution0 extends BinaryNumberWithAlternatingBits {
    def hasAlternatingBits(n: Int): Boolean =
      n.toBinaryString.matches("^(10)*(1)?$")
  }

  case object Solution1 extends BinaryNumberWithAlternatingBits {
    def hasAlternatingBits(n: Int): Boolean = {
      val num = (n >> 1) ^ n
      (num & (num + 1)) == 0
    }
  }

  case object Solution2 extends BinaryNumberWithAlternatingBits {
    def hasAlternatingBits(n: Int): Boolean =
      Set(0, 1, 2, 5, 10, 21, 42, 85, 170, 341, 682, 1365, 2730, 5461, 10922, 21845, 43690, 87381, 174762, 349525,
        699050, 1398101, 2796202, 5592405, 11184810, 22369621, 44739242, 89478485, 178956970, 357913941, 715827882,
        1431655765).apply(n)
  }

}
