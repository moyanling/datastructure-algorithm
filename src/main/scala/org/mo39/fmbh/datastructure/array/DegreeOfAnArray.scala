package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a non-empty array of non-negative integers nums, the degree of
  * this array is defined as the maximum frequency of any one of its
  * elements.
  * Your task is to find the smallest possible length of a (contiguous)
  * subarray of nums, that has the same degree as nums.
  *
  * Example 1:
  *
  * Input: [1, 2, 2, 3, 1]
  * Output: 2
  * Explanation:
  * The input array has a degree of 2 because both elements 1 and 2 appear
  * twice.
  * Of the subarrays that have the same degree:
  * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2,
  * 2]
  * The shortest length is 2. So return 2.
  *
  *
  *
  *
  * Example 2:
  *
  * Input: [1,2,2,3,1,4,2]
  * Output: 6
  *
  *
  *
  * Note:
  * nums.length will be between 1 and 50,000.
  * nums[i] will be an integer between 0 and 49,999.
  * }}}
  *
  * @see [[https://leetcode.com/problems/degree-of-an-array/ DegreeOfAnArray]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait DegreeOfAnArray {
  def findShortestSubArray(nums: Array[Int]): Int
}

object DegreeOfAnArray extends Enumerable[DegreeOfAnArray] {

  case object Solution extends DegreeOfAnArray {
    override def findShortestSubArray(nums: Array[Int]): Int = {
      val groups = nums.zipWithIndex.groupBy(_._1)
      val degree = groups.map(_._2.length).max
      groups
        .filter(_._2.length == degree)
        .values
        .map(arr => arr.last._2 - arr.head._2 + 1)
        .min
    }
  }

}
