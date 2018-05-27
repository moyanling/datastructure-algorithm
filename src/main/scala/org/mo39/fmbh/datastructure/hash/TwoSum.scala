package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given an array of integers, return indices of the two numbers such that
  * they add up to a specific target.
  *
  * You may assume that each input would have exactly one solution, and you
  * may not use the same element twice.
  *
  * Example:
  *
  *
  * Given nums = [2, 7, 11, 15], target = 9,
  *
  * Because nums[0] + nums[1] = 2 + 7 = 9,
  * return [0, 1].
  *
  *
  *  
  * }}}
  *
  * @see [[https://leetcode.com/problems/two-sum/ TwoSum]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int]
}

object TwoSum extends Enumerable[TwoSum] {
  case object Solution0 extends TwoSum {
    override def twoSum(nums: Array[Int], target: Int): Array[Int] = {
      val map = nums.zipWithIndex.toMap
      for (i <- nums.indices) {
        if (i != map.getOrElse(target - nums(i), i))
          return Array(i, map(target - nums(i)))
      }
      Array()
    }
  }
  case object Solution1 extends TwoSum {
    override def twoSum(nums: Array[Int], target: Int): Array[Int] = {
      val map = nums.zipWithIndex.toMap
      val i   = nums.indices.find(i => i != map.getOrElse(target - nums(i), i)).get
      Array(i, map(target - nums(i)))
    }
  }
}
