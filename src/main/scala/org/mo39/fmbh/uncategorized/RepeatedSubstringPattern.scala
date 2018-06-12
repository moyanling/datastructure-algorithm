package org.mo39.fmbh.uncategorized

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a non-empty string check if it can be constructed by taking a
  * substring of it and appending multiple copies of the substring
  * together.  You may assume the given string consists of lowercase
  * English letters only and its length  will not exceed 10000.
  *
  * Example 1:
  *
  * Input: "abab"
  *
  * Output: True
  *
  * Explanation: It's the substring "ab" twice.
  *
  *
  *
  * Example 2:
  *
  * Input: "aba"
  *
  * Output: False
  *
  *
  *
  * Example 3:
  *
  * Input: "abcabcabcabc"
  *
  * Output: True
  *
  * Explanation: It's the substring "abc" four times. (And the substring
  * "abcabc" twice.)
  * }}}
  *
  * @see [[https://leetcode.com/problems/repeated-substring-pattern/ RepeatedSubstringPattern]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait RepeatedSubstringPattern {
  def repeatedSubstringPattern(s: String): Boolean
}

object RepeatedSubstringPattern extends Enumerable[RepeatedSubstringPattern] {

  /**
    * Concise but not fast enough
    */
  case object Solution0 extends RepeatedSubstringPattern {
    override def repeatedSubstringPattern(s: String): Boolean = {
      (1 to s.length / 2).exists(i => s.length % i == 0 && s.take(i) * (s.length / i) == s)
    }
  }

  case object Solution1 extends RepeatedSubstringPattern {
    override def repeatedSubstringPattern(s: String): Boolean = ???
  }

}
