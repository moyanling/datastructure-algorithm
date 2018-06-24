package org.mo39.fmbh.algorithm.sort

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.Interval
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a collection of intervals, merge all overlapping intervals.
  *
  * Example 1:
  *
  *
  * Input: [[1,3],[2,6],[8,10],[15,18]]
  * Output: [[1,6],[8,10],[15,18]]
  * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
  * [1,6].
  *
  *
  * Example 2:
  *
  *
  * Input: [[1,4],[4,5]]
  * Output: [[1,5]]
  * Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
  * }}}
  *
  * @see [[https://leetcode.com/problems/merge-intervals/ MergeIntervals]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MergeIntervals {
  def merge(intervals: List[Interval]): List[Interval]
}

object MergeIntervals extends Enumerable[MergeIntervals] {
  case object Solution0 extends MergeIntervals {
    override def merge(intervals: List[Interval]): List[Interval] = {
      val sortedStart = intervals.sortBy(_.start)
      def recur(list: List[Interval], i: Int): List[Interval] = {
        if (i >= list.length - 1) return list
        if (list(i).end >= list(i + 1).start) {
          val (left, right) = list.splitAt(i)
          val merged        = Interval(list(i).start, math.max(list(i).end, list(i + 1).end))
          val updated       = left ::: merged :: right.tail.tail
          recur(updated, i)
        } else recur(list, i + 1)
      }
      recur(sortedStart, 0)
    }
  }
  case object Solution1 extends MergeIntervals {
    override def merge(intervals: List[Interval]): List[Interval] = {
      var sorted = intervals.sortBy(_.start)
      var result = List[Interval]()
      while (sorted.nonEmpty) {
        if (sorted.size > 1 && sorted.head.end >= sorted(1).start) {
          val merged = Interval(sorted.head.start, math.max(sorted.head.end, sorted(1).end))
          sorted = merged :: sorted.tail.tail
        } else {
          result = sorted.head :: result
          sorted = sorted.tail
        }
      }
      result
    }
  }

  /**
    * This fold left is so cool.
    */
  case object Solution2 extends MergeIntervals {
    override def merge(intervals: List[Interval]): List[Interval] =
      intervals
        .sortBy(_.start)
        .foldLeft(List[Interval]())((acc, i) =>
          acc match {
            case h :: _ if h.end >= i.start => Interval(h.start, i.end.max(h.end)) :: acc.tail
            case _                          => i :: acc
        })
  }

}
