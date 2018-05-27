package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * You are given a string representing an attendance record for a student.
  * The record only contains the following three characters:
  *
  *
  *
  * 'A' : Absent.
  * 'L' : Late.
  * 'P' : Present.
  *
  *
  *
  *
  * A student could be rewarded if his attendance record doesn't contain
  * more than one 'A' (absent) or more than two continuous 'L' (late).
  *
  * You need to return whether the student could be rewarded according to
  * his attendance record.
  *
  * Example 1:
  *
  * Input: "PPALLP"
  * Output: True
  *
  *
  *
  * Example 2:
  *
  * Input: "PPALLL"
  * Output: False
  * }}}
  *
  * @see [[https://leetcode.com/problems/student-attendance-record-i/ StudentAttendanceRecordI]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait StudentAttendanceRecordI {
  def checkRecord(s: String): Boolean
}

object StudentAttendanceRecordI extends Enumerable[StudentAttendanceRecordI] {
  case object Solution extends StudentAttendanceRecordI {
    override def checkRecord(s: String): Boolean = s.count(_ == 'A') < 2 && !s.contains("LLL")
  }
}
