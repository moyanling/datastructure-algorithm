package org.mo39.fmbh.algorithm.detectloop

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Write an algorithm to determine if a number is "happy".
  *
  * A happy number is a number defined by the following process: Starting
  * with any positive integer, replace the number by the sum of the squares
  * of its digits, and repeat the process until the number equals 1 (where
  * it will stay), or it loops endlessly in a cycle which does not include
  * 1. Those numbers for which this process ends in 1 are happy numbers.
  *
  * Example: 
  *
  *
  * Input: 19
  * Output: true
  * Explanation:
  * 12 + 92 = 82
  * 82 + 22 = 68
  * 62 + 82 = 100
  * 12 + 02 + 02 = 1
  * }}}
  *
  * @see [[https://leetcode.com/problems/happy-number/ HappyNumber]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait HappyNumber {
  def isHappy(n: Int): Boolean
}

object HappyNumber extends Enumerable[HappyNumber] {
  case object Solution0 extends HappyNumber {
    override def isHappy(n: Int): Boolean = {
      var set = Set[Int]()
      def recur(n: Int): Boolean = {
        val sum = n.toString.map(i => i.asDigit * i.asDigit).sum
        if (sum == 1) true
        else {
          if (set.contains(sum)) false
          else { set += sum; recur(sum) }
        }
      }
      recur(n)
    }
  }
  case object Solution1 extends HappyNumber {
    override def isHappy(n: Int): Boolean = {
      val cal  = (n: Int) => n.toString.map(i => i.asDigit * i.asDigit).sum
      var x, y = n
      while (x > 1) {
        x = cal(x)
        y = cal(cal(y))
        if (x == 1 || y == 1) return true
        else if (x == y) return false
      }
      true
    }
  }
}
