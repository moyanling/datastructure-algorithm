package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a string which consists of lowercase or uppercase letters, find
  * the length of the longest palindromes that can be built with those
  * letters.
  *
  * This is case sensitive, for example "Aa" is not considered a palindrome
  * here.
  *
  * Note:
  * Assume the length of given string will not exceed 1,010.
  *
  *
  * Example:
  *
  * Input:
  * "abccccdd"
  *
  * Output:
  * 7
  *
  * Explanation:
  * One longest palindrome that can be built is "dccaccd", whose length is
  * 7.
  * }}}
  *
  * @see [[https://leetcode.com/problems/longest-palindrome/ LongestPalindrome]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait LongestPalindrome {
  def longestPalindrome(s: String): Int
}

object LongestPalindrome extends Enumerable[LongestPalindrome] {
  case object Solution extends LongestPalindrome {
    override def longestPalindrome(s: String): Int = {
      val counts = s.groupBy(identity).values.map(_.length)
      counts.map(i => if (i % 2 == 0) i else i - 1).sum + (if (counts.exists(_ % 2 != 0)) 1 else 0)
    }
  }

}
