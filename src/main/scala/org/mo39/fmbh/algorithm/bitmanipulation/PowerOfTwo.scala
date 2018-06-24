package org.mo39.fmbh.algorithm.bitmanipulation

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given an integer, write a function to determine if it is a power of
  * two.
  *
  * Example 1:
  *
  *
  * Input: 1
  * Output: true
  * Explanation: 20 = 1
  *
  *
  * Example 2:
  *
  *
  * Input: 16
  * Output: true
  * Explanation: 24 = 16
  *
  * Example 3:
  *
  *
  * Input: 218
  * Output: false
  * }}}
  *
  * @see [[https://leetcode.com/problems/power-of-two/ PowerOfTwo]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait PowerOfTwo {
  def isPowerOfTwo(n: Int): Boolean
}

object PowerOfTwo extends Enumerable[PowerOfTwo] {

  case object Solution0 extends PowerOfTwo {
    val isPowerOfTwo = Set(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072,
      262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912)
    override def isPowerOfTwo(n: Int): Boolean = isPowerOfTwo.apply(n)
  }

  case object Solution1 extends PowerOfTwo {
    override def isPowerOfTwo(n: Int): Boolean = n > 0 && (n & (n - 1)) == 0
  }
}
