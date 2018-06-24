package org.mo39.fmbh.algorithm.sort

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.util.Sorting

/**
  * {{{
  * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
  *
  * Example:
  *
  * Input: nums = [3,5,2,1,6,4]
  * Output: One possible answer is [3,5,1,6,2,4]
  * }}}
  *
  * @see [[https://leetcode.com/problems/wiggle-sort/ WiggleSort]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait WiggleSort {
  def wiggleSort(nums: Array[Int]): Unit
}

object WiggleSort extends Enumerable[WiggleSort] {
  case object Solution0 extends WiggleSort {
    override def wiggleSort(nums: Array[Int]): Unit = {
      Sorting.quickSort(nums)
      for (i <- 1 until nums.length by 2) {
        swap(nums, i, i + 1)
      }
    }
  }

  case object Solution1 extends WiggleSort {
    override def wiggleSort(nums: Array[Int]): Unit = {
      var flag = true
      for (i <- 0 until nums.length - 1) {
        if ((nums(i) < nums(i + 1)) != flag && nums(i) != nums(i + 1)) swap(nums, i, i + 1)
        flag = !flag
      }
    }
  }

  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    if (i == j || j >= arr.length) return
    arr(i) = arr(i) ^ arr(j) // now a is 6 and b is 4
    arr(j) = arr(i) ^ arr(j) // now a is 6 but b is 2 (original value of a)
    arr(i) = arr(i) ^ arr(j)
  }
}
