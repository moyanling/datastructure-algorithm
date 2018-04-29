package org.mo39.fmbh.algorithm.bitmanipulation

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ListBuffer

/**
  * {{{
  * Calculate the sum of two integers a and b, but you are not allowed to
  * use the operator + and -.
  *
  * Example:
  * Given a = 1 and b = 2, return 3.
  *
  *
  * Credits:Special thanks to @fujiaozhu for adding this problem and
  * creating all test cases.
  * }}}
  *
  * @see [[https://leetcode.com/problems/sum-of-two-integers/ SumOfTwoIntegers]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
trait SumOfTwoIntegers {
  def getSum(a: Int, b: Int): Int
}

object SumOfTwoIntegers extends Enumerable[SumOfTwoIntegers] {
  /*
   * This one basically uses BinaryString and ^ to add bits one by one.
   * It fails at Integer.parseInt because of integer overflow.
   */
  case object Solution0 extends SumOfTwoIntegers {
    override def getSum(a: Int, b: Int): Int = {
      var Array(carry, i) = Array(0, 0)
      val A = a.toBinaryString.map(_.asDigit)
      val B = b.toBinaryString.map(_.asDigit)
      val arr = ListBuffer[Int]()
      while (i < A.length || i < B.length || carry != 0) {
        val iA = if (i < A.length) A(A.length - i - 1) else 0
        val iB = if (i < B.length) B(B.length - i - 1) else 0
        (carry ^ iA ^ iB) +=: arr
        carry = if (Array(carry, iA, iB).count(_ == 1) > 1) 1 else 0
        i += 1
      }
      Integer.parseInt(arr.mkString, 2)
    }
  }

  case object Solution1 extends SumOfTwoIntegers {
    override def getSum(a: Int, b: Int): Int = ???
  }

}
