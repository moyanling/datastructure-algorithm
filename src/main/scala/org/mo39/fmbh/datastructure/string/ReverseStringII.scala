package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  *
  * Given a string and an integer k, you need to reverse the first k
  * characters for every 2k characters counting from the start of the
  * string. If there are less than k characters left, reverse all of them.
  * If there are less than 2k but greater than or equal to k characters,
  * then reverse the first k characters and left the other as original.
  *
  *
  * Example:
  *
  * Input: s = "abcdefg", k = 2
  * Output: "bacdfeg"
  *
  *
  *
  * Restrictions:
  *
  *  The string consists of lower English letters only.
  *  Length of the given string and k will in the range [1, 10000]
  * }}}
  *
  * @see [[https://leetcode.com/problems/reverse-string-ii/ ReverseStringII]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait ReverseStringII {
  def reverseStr(s: String, k: Int): String
}

object ReverseStringII extends Enumerable[ReverseStringII] {
  case object Solution extends ReverseStringII {
    override def reverseStr(s: String, k: Int): String =
      s.grouped(k).zipWithIndex.map(t => if (t._2 % 2 == 0) t._1.reverse else t._1).mkString
  }
}
