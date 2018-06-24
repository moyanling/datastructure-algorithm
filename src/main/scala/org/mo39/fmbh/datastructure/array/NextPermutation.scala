package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Implement next permutation, which rearranges numbers into the
  * lexicographically next greater permutation of numbers.
  *
  * If such arrangement is not possible, it must rearrange it as the lowest
  * possible order (ie, sorted in ascending order).
  *
  * The replacement must be in-place and use only constant extra memory.
  *
  * Here are some examples. Inputs are in the left-hand column and its
  * corresponding outputs are in the right-hand column.
  *
  * 1,2,3 → 1,3,2
  * 3,2,1 → 1,2,3
  * 1,1,5 → 1,5,1
  * }}}
  *
  * @see [[https://leetcode.com/problems/next-permutation/ NextPermutation]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait NextPermutation {
  def nextPermutation(nums: Array[Int]): Unit
}

object NextPermutation extends Enumerable[NextPermutation] {
  case object Solution extends NextPermutation {
    override def nextPermutation(nums: Array[Int]): Unit = {
      val i = nums.indices.lastIndexWhere(i => i == 0 || nums(i) > nums(i - 1))
      reverse(nums, i)
      if (i > 0) {
        val nextLarger = nums.indexWhere(_ > nums(i - 1), i)
        swap(nums, i - 1, nextLarger)
      }
    }
    def reverse(nums: Array[Int], start: Int): Unit =
      for (i <- start until start + (nums.length - start) / 2) {
        swap(nums, i, start + nums.length - 1 - i)
      }
    def swap(nums: Array[Int], i: Int, j: Int): Unit =
      if (i != j) {
        val tmp = nums(i)
        nums(i) = nums(j)
        nums(j) = tmp
      }
  }
}
