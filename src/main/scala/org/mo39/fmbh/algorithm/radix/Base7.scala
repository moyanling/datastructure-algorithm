package org.mo39.fmbh.algorithm.radix

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given an integer, return its base 7 string representation.
  *
  * Example 1:
  *
  * Input: 100
  * Output: "202"
  *
  *
  *
  * Example 2:
  *
  * Input: -7
  * Output: "-10"
  *
  *
  *
  * Note:
  * The input will be in range of [-1e7, 1e7].
  * }}}
  *
  * @see [[https://leetcode.com/problems/base-7/ Base7]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait Base7 {
  def convertToBase7(num: Int): String
}

object Base7 extends Enumerable[Base7] {

  case object Solution0 extends Base7 {
    override def convertToBase7(num: Int): String = Integer.toString(num, 7)
  }

  case object Solution1 extends Base7 {
    override def convertToBase7(num: Int): String = {
      if (num == 0) return "0"
      val weight = List(5764801, 823543, 117649, 16807, 2401, 343, 49, 7, 1)
      val sb     = new StringBuilder()
      var n      = math.abs(num)
      for (w <- weight) {
        val c = n / w
        if (sb.isEmpty && c != 0 || sb.nonEmpty) sb.append(c)
        n %= w
      }
      if (num < 0) "-" + sb.toString()
      else sb.toString()
    }
  }

  case object Solution2 extends Base7 {
    override def convertToBase7(num: Int): String = {
      if (num == 0) return "0"
      var list: List[Int] = Nil
      var n               = math.abs(num)
      while (n > 0) {
        list = n % 7 :: list
        n /= 7
      }
      if (num < 0) "-" + list.mkString
      else list.mkString
    }
  }

}
