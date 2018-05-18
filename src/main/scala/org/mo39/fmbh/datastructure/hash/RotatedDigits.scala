package org.mo39.fmbh.datastructure.hash
import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * X is a good number if after rotating each digit individually by 180
  * degrees, we get a valid number that is different from X.  Each
  * digit must be rotated - we cannot choose to leave it alone.
  *
  * A number is valid if each digit remains a digit after rotation. 0, 1,
  * and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9
  * rotate to each other, and the rest of the numbers do not rotate to any
  * other number and become invalid.
  *
  * Now given a positive number N, how many numbers X from 1 to N are
  * good?
  *
  *
  * Example:
  * Input: 10
  * Output: 4
  * Explanation:
  * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
  * Note that 1 and 10 are not good numbers, since they remain unchanged
  * after rotating.
  *
  *
  * Note:
  *
  *
  * 	N  will be in range [1, 10000].
  * }}}
  *
  * @see [[https://leetcode.com/problems/rotated-digits/ RotatedDigits]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
trait RotatedDigits {
  def rotatedDigits(N: Int): Int
}

object RotatedDigits extends Enumerable[RotatedDigits] {

  case object Solution extends RotatedDigits {
    override def rotatedDigits(N: Int): Int = {
      val isInvalid = Set(3, 4, 7)
      val mustHave  = Set(2, 5, 6, 9)
      val isGood = (n: Int) => {
        val arr = n.toString.map(_.asDigit)
        !arr.exists(isInvalid) && arr.exists(mustHave)
      }
      (1 to N).count(isGood)
    }
  }

}
