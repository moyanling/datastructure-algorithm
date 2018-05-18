package org.mo39.fmbh.algorithm.sort

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.Interval
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given an array of meeting time intervals consisting of start and end times
  * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
  *
  * For example,
  * Given [[0, 30],[5, 10],[15, 20]],
  * return false.
  * }}}
  *
  * @see [[https://leetcode.com/problems/meeting-rooms/ MeetingRooms]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
trait MeetingRooms {
  def canAttendMeetings(intervals: Array[Interval]): Boolean
}

object MeetingRooms extends Enumerable[MeetingRooms] {
  /* Don't mess up the logic of List.forall and List.exists */
  case object Solution extends MeetingRooms {
    override def canAttendMeetings(intervals: Array[Interval]): Boolean = {
      val arr = intervals.sortBy(_.start)
      (1 until arr.length).forall(i => arr(i - 1).end <= arr(i).start)
    }
  }
}
