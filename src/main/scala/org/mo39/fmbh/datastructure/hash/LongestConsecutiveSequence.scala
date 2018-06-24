package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable

/**
  * {{{
  * Given an unsorted array of integers, find the length of the longest
  * consecutive elements sequence.
  *
  * Your algorithm should run in O(n) complexity.
  *
  * Example:
  *
  *
  * Input: [100, 4, 200, 1, 3, 2]
  * Output: 4
  * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
  * Therefore its length is 4.
  * }}}
  *
  * @see [[https://leetcode.com/problems/longest-consecutive-sequence/ LongestConsecutiveSequence]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait LongestConsecutiveSequence {
  def longestConsecutive(nums: Array[Int]): Int
}

object LongestConsecutiveSequence extends Enumerable[LongestConsecutiveSequence] {
  case object Solution extends LongestConsecutiveSequence {
    override def longestConsecutive(nums: Array[Int]): Int = {
      var max = 0
      val map = mutable.Map[Int, Int]()
      for (n <- nums if !map.contains(n)) {
        val (left, right) = (map.getOrElse(n - 1, 0), map.getOrElse(n + 1, 0))
        val len           = left + right + 1
        max = math.max(max, len)
        map.update(n, 0)
        map.update(n - left, len)
        map.update(n + right, len)
      }
      max
    }
  }
}
