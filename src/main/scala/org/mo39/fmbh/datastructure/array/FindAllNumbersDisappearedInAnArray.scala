package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable

/**
  * {{{
  * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some
  * elements appear twice and others appear once.
  *
  * Find all the elements of [1, n] inclusive that do not appear in this
  * array.
  *
  * Could you do it without extra space and in O(n) runtime? You may assume
  * the returned list does not count as extra space.
  *
  * Example:
  *
  * Input:
  * [4,3,2,7,8,2,3,1]
  *
  * Output:
  * [5,6]
  * }}}
  *
  * @see [[https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/ FindAllNumbersDisappearedInAnArray]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait FindAllNumbersDisappearedInAnArray {
  def findDisappearedNumbers(nums: Array[Int]): List[Int]
}

object FindAllNumbersDisappearedInAnArray extends Enumerable[FindAllNumbersDisappearedInAnArray] {

  case object Solution0 extends FindAllNumbersDisappearedInAnArray {
    override def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
      val result = mutable.ListBuffer[Int]()
      val len    = nums.length + 1
      for (i <- nums.indices) {
        val v = nums(i) % len - 1
        nums(v) = nums(v) % len + len
      }
      nums.indices.foreach(i => if (nums(i) <= len) result += i + 1)
      result.toList
    }
  }

  case object Solution1 extends FindAllNumbersDisappearedInAnArray {
    override def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
      val result = mutable.ListBuffer[Int]()
      for (i <- nums.indices) {
        val j = Math.abs(nums(i)) - 1
        nums(j) = -Math.abs(nums(j))
      }
      nums.indices.foreach(i => if (nums(i) > 0) result += i + 1)
      result.toList
    }
  }
}
