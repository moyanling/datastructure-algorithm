package org.mo39.fmbh.datastructure.array2d

import java.util.{ Comparator, PriorityQueue }

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given m arrays, and each array is sorted in ascending order.
  * Now you can pick up two integers from two different arrays (each array picks one)
  * and calculate the distance.
  * We define the distance between two integers a and b to be their absolute difference |a-b|.
  * Your task is to find the maximum distance.
  *
  * Example 1:
  * Input:
  * [[1,2,3],
  *  [4,5],
  *  [1,2,3]]
  * Output: 4
  * Explanation:
  * One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
  * Note:
  * Each given array will have at least 1 number. There will be at least two non-empty arrays.
  * The total number of the integers in all the m arrays will be in the range of [2, 10000].
  * The integers in the m arrays will be in the range of [-10000, 10000].
  * }}}
  *
  * @see [[https://leetcode.com/problems/maximum-distance-in-arrays/ MaximumDistanceInArrays]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MaximumDistanceInArrays {
  def maxDistance(arrays: List[List[Int]]): Int
}

object MaximumDistanceInArrays extends Enumerable[MaximumDistanceInArrays] {
  case object Solution extends MaximumDistanceInArrays {
    override def maxDistance(arrays: List[List[Int]]): Int = {
      val max = new PriorityQueue[(Int, Int)](2, ((o1, o2) => o2._1 - o1._1): Comparator[(Int, Int)])
      val min = new PriorityQueue[(Int, Int)](2)
      val arr = arrays.zipWithIndex
      arr.map(t => (t._1.head, t._2)).foreach(min.add)
      arr.map(t => (t._1.last, t._2)).foreach(max.add)
      val (a, b) = (max.poll, max.poll)
      val (c, d) = (min.poll, min.poll)
      if (a._2 != c._2) a._1 - c._1
      else (a._1 - d._1).max(b._1 - d._1)
    }
  }
}
