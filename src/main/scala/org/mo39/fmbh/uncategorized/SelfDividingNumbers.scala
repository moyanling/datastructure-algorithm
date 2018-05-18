package org.mo39.fmbh.uncategorized

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  *
  * A self-dividing number is a number that is divisible by every digit it
  * contains.
  *
  * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 %
  * 2 == 0, and 128 % 8 == 0.
  *
  * Also, a self-dividing number is not allowed to contain the digit zero.
  *
  * Given a lower and upper number bound, output a list of every possible
  * self dividing number, including the bounds if possible.
  *
  * Example 1:
  *
  * Input:
  * left = 1, right = 22
  * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
  *
  *
  *
  * Note:
  * The boundaries of each input argument are 1 <= left <= right <= 10000.
  * }}}
  *
  * @see [[https://leetcode.com/problems/self-dividing-numbers/ SelfDividingNumbers]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SelfDividingNumbers {
  def selfDividingNumbers(left: Int, right: Int): List[Int]
}

object SelfDividingNumbers extends Enumerable[SelfDividingNumbers] {
  case object Solution extends SelfDividingNumbers {
    def selfDividingNumbers(left: Int, right: Int): List[Int] = {
      (left to right)
        .filterNot(num =>
          num.toString.exists(n => n == '0' || num % n.asDigit != 0))
        .toList
    }

  }
}
