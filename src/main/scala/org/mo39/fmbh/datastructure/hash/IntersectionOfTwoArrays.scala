package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  *
  * Given two arrays, write a function to compute their intersection.
  *
  *
  * Example:
  * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
  *
  *
  * Note:
  *
  * Each element in the result must be unique.
  * The result can be in any order.
  * }}}
  *
  * @see [[https://leetcode.com/problems/intersection-of-two-arrays/ IntersectionOfTwoArrays]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait IntersectionOfTwoArrays {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int]
}

object IntersectionOfTwoArrays extends Enumerable[IntersectionOfTwoArrays] {
  case object Solution extends IntersectionOfTwoArrays {
    override def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] =
      nums1.toSet.intersect(nums2.toSet).toArray
  }
}
