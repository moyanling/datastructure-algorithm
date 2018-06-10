package org.mo39.fmbh.algorithm.dichotomy

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a positive integer num, write a function which returns True if
  * num is a perfect square else False.
  *
  *
  * Note: Do not use any built-in library function such as sqrt.
  *
  *
  * Example 1:
  *
  * Input: 16
  * Returns: True
  *
  *
  *
  * Example 2:
  *
  * Input: 14
  * Returns: False
  *
  *
  *
  * Credits:Special thanks to @elmirap for adding this problem and creating
  * all test cases.
  * }}}
  *
  * @see [[https://leetcode.com/problems/valid-perfect-square/ ValidPerfectSquare]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait ValidPerfectSquare {
  def isPerfectSquare(num: Int): Boolean
}

object ValidPerfectSquare extends Enumerable[ValidPerfectSquare] {

  case object Solution0 extends ValidPerfectSquare {
    override def isPerfectSquare(num: Int): Boolean = {
      val i = (1l to num / 2 + 1).find(i => i * i <= num && (i + 1) * (i + 1) > num)
      i.isDefined && i.get * i.get == num
    }
  }

  case object Solution1 extends ValidPerfectSquare {
    override def isPerfectSquare(num: Int): Boolean =
      num match {
        case _ if num > 2147395600 => false
        case _ =>
          val range  = 1 to math.min(num / 2 + 1, 46340)
          var (i, j) = (range.head, range.last)
          while (i < j) {
            val mid = (i + j) / 2
            val s   = mid * mid
            if (s == num) return true
            else if (s < num) i = mid + 1
            else j = mid
          }
          i * i == num
      }
  }

}
