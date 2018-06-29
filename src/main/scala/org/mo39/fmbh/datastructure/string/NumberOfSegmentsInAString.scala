package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Count the number of segments in a string, where a segment is defined to
  * be a contiguous sequence of non-space characters.
  *
  * Please note that the string does not contain any non-printable
  * characters.
  *
  * Example:
  *
  * Input: "Hello, my name is John"
  * Output: 5
  * }}}
  *
  * @see [[https://leetcode.com/problems/number-of-segments-in-a-string/ NumberOfSegmentsInAString]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait NumberOfSegmentsInAString {
  def countSegments(s: String): Int
}

object NumberOfSegmentsInAString extends Enumerable[NumberOfSegmentsInAString] {
  case object Solution extends NumberOfSegmentsInAString {
    override def countSegments(s: String): Int = if (s == "") 0 else s.trim.split("\\s+").length
  }

  case object Solution1 extends NumberOfSegmentsInAString {
    override def countSegments(s: String): Int = s.split("\\s+").count(_.length != 0)
  }
}
