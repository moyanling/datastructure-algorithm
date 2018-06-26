package org.mo39.fmbh.algorithm.sort

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ArrayBuffer

/**
  * {{{
  * You are given an integer array nums and you have to return a new counts
  * array. The counts array has the property where counts[i] is the number
  * of smaller elements to the right of nums[i].
  *
  * Example:
  *
  *
  * Input: [5,2,6,1]
  * Output: [2,1,1,0]
  * Explanation:
  * To the right of 5 there are 2 smaller elements (2 and 1).
  * To the right of 2 there is only 1 smaller element (1).
  * To the right of 6 there is 1 smaller element (1).
  * To the right of 1 there is 0 smaller element.
  * }}}
  *
  * @see [[https://leetcode.com/problems/count-of-smaller-numbers-after-self/ CountOfSmallerNumbersAfterSelf]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait CountOfSmallerNumbersAfterSelf {
  def countSmaller(nums: Array[Int]): List[Int]
}

object CountOfSmallerNumbersAfterSelf extends Enumerable[CountOfSmallerNumbersAfterSelf] {
  case object Solution extends CountOfSmallerNumbersAfterSelf {
    override def countSmaller(nums: Array[Int]): List[Int] = {
      if (nums.length == 0) return Nil
      var result = List(0)
      val sorted = ArrayBuffer[Int](nums.last)
      for (i <- nums.length - 2 to 0 by -1) {
        val n      = nums(i)
        var (p, q) = (0, sorted.length)
        while (p < q) {
          val mid = (p + q) / 2
          if (sorted(mid) >= n) p = mid + 1
          else q = mid
        }
        result = sorted.length - p :: result
        sorted.insert(p, n)
      }
      result
    }
  }
}
