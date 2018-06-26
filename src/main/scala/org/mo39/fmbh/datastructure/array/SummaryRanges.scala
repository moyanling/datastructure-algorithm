package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ListBuffer

/**
  * {{{
  * Given a sorted integer array without duplicates, return the summary of
  * its ranges.
  *
  * Example 1:
  *
  *
  * Input:  [0,1,2,4,5,7]
  * Output: ["0->2","4->5","7"]
  * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous
  * range.
  *
  *
  * Example 2:
  *
  *
  * Input:  [0,2,3,4,6,8,9]
  * Output: ["0","2->4","6","8->9"]
  * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous
  * range.
  * }}}
  *
  * @see [[https://leetcode.com/problems/summary-ranges/ SummaryRanges]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SummaryRanges {
  def summaryRanges(nums: Array[Int]): List[String]
}

object SummaryRanges extends Enumerable[SummaryRanges] {
  case object Solution0 extends SummaryRanges {
    override def summaryRanges(nums: Array[Int]): List[String] = {
      if (nums.length == 0) return Nil
      var i      = 0
      var ranges = ListBuffer[(Int, Int)]()
      for (j <- 1 until nums.length if nums(j) != nums(j - 1) + 1) {
        ranges += ((nums(i), nums(j - 1)))
        i = j
      }
      ranges += ((nums(i), nums.last))
      ranges.map { r =>
        if (r._1 == r._2) r._1.toString
        else r._1 + "->" + r._2
      }.toList
    }
  }

  case object Solution1 extends SummaryRanges {
    override def summaryRanges(nums: Array[Int]): List[String] = {
      var i      = 0
      var ranges = ListBuffer[String]()
      for (j <- 1 to nums.length if j == nums.length || nums(j) != nums(j - 1) + 1) {
        val (left, right) = (nums(i), nums(j - 1))
        ranges += (if (left == right) left.toString else left + "->" + right)
        i = j
      }
      ranges.toList
    }
  }

}
