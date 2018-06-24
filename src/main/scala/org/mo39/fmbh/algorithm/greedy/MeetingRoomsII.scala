package org.mo39.fmbh.algorithm.greedy

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.Interval
import org.mo39.fmbh.commons.utils.Enumerable

import scala.util.Sorting

/**
  * {{{
  * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...]
  * (si < ei), find the minimum number of conference rooms required.
  *
  * Example 1:
  *
  * Input: [[0, 30],[5, 10],[15, 20]]
  * Output: 2
  * Example 2:
  *
  * Input: [[7,10],[2,4]]
  * Output: 1
  * }}}
  *
  * @see [[https://leetcode.com/problems/meeting-rooms-ii/ MeetingRoomsII]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MeetingRoomsII {
  def minMeetingRooms(intervals: Array[Interval]): Int
}

object MeetingRoomsII extends Enumerable[MeetingRoomsII] {
  case object Solution extends MeetingRoomsII {
    override def minMeetingRooms(intervals: Array[Interval]): Int = ???
  }
}
