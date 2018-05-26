package org.mo39.fmbh.uncategorized

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given an integer array, find three numbers whose product is maximum and
  * output the maximum product.
  *
  * Example 1:
  *
  * Input: [1,2,3]
  * Output: 6
  *
  *
  *
  * Example 2:
  *
  * Input: [1,2,3,4]
  * Output: 24
  *
  *
  *
  * Note:
  *
  * The length of the given array will be in range [3,104] and all elements
  * are in the range [-1000, 1000].
  * Multiplication of any three numbers in the input won't exceed the range
  * of 32-bit signed integer.
  * }}}
  *
  * @see [[https://leetcode.com/problems/maximum-product-of-three-numbers/ MaximumProductOfThreeNumbers]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MaximumProductOfThreeNumbers {
  def maximumProduct(nums: Array[Int]): Int
}

object MaximumProductOfThreeNumbers extends Enumerable[MaximumProductOfThreeNumbers] {

  case object Solution extends MaximumProductOfThreeNumbers {
    override def maximumProduct(nums: Array[Int]): Int = ???
  }

}