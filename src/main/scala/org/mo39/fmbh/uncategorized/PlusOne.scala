package org.mo39.fmbh.uncategorized

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a non-empty array of digits representing a non-negative integer,
  * plus one to the integer.
  *
  * The digits are stored such that the most significant digit is at the
  * head of the list, and each element in the array contain a single digit.
  *
  * You may assume the integer does not contain any leading zero, except
  * the number 0 itself.
  *
  * Example 1:
  *
  *
  * Input: [1,2,3]
  * Output: [1,2,4]
  * Explanation: The array represents the integer 123.
  *
  *
  * Example 2:
  *
  *
  * Input: [4,3,2,1]
  * Output: [4,3,2,2]
  * Explanation: The array represents the integer 4321.
  * }}}
  *
  * @see [[https://leetcode.com/problems/plus-one/ PlusOne]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait PlusOne {
  def plusOne(digits: Array[Int]): Array[Int]
}

object PlusOne extends Enumerable[PlusOne] {
  case object Solution extends PlusOne {
    override def plusOne(digits: Array[Int]): Array[Int] = {
      digits(digits.length - 1) = digits.last + 1
      var i = digits.length - 1
      while (i >= 0 && digits(i) > 9) {
        digits(i) = 0
        if (i > 0) digits(i - 1) += 1
        i -= 1
      }
      if (digits(0) == 0) 1 +: digits else digits
    }
  }
}
