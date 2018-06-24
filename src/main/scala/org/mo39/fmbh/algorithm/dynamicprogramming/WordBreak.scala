package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a non-empty string s and a dictionary wordDict containing a list
  * of non-empty words, determine if s can be segmented into a
  * space-separated sequence of one or more dictionary words.
  *
  * Note:
  *
  *
  * 	The same word in the dictionary may be reused multiple times in the
  * segmentation.
  * 	You may assume the dictionary does not contain duplicate words.
  *
  *
  * Example 1:
  *
  *
  * Input: s = "leetcode", wordDict = ["leet", "code"]
  * Output: true
  * Explanation: Return true because "leetcode" can be segmented as "leet
  * code".
  *
  *
  * Example 2:
  *
  *
  * Input: s = "applepenapple", wordDict = ["apple", "pen"]
  * Output: true
  * Explanation: Return true because "applepenapple" can be segmented as
  * "apple pen apple".
  *              Note that you are allowed to reuse a dictionary word.
  *
  *
  * Example 3:
  *
  *
  * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and",
  * "cat"]
  * Output: false
  * }}}
  *
  * @see [[https://leetcode.com/problems/word-break/ WordBreak]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait WordBreak {
  def wordBreak(s: String, wordDict: List[String]): Boolean
}

object WordBreak extends Enumerable[WordBreak] {
  case object Solution0 extends WordBreak {
    override def wordBreak(s: String, wordDict: List[String]): Boolean = {
      val set = wordDict.toSet
      def wordBreak(a: String): Boolean =
        (a == "") || (1 to a.length).exists { i =>
          set.contains(a.substring(0, i)) && wordBreak(a.substring(i))
        }
      wordBreak(s)
    }
  }
  case object Solution1 extends WordBreak {
    override def wordBreak(s: String, wordDict: List[String]): Boolean = {
      val set  = wordDict.toSet
      val memo = Array.fill(s.length + 1) { false }
      for (i <- 1 to s.length) {
        if (set.contains(s.substring(0, i))) memo(i) = true
        else {
          for (j <- 0 until i if memo(j) && !memo(i)) {
            if (set.contains(s.substring(j, i))) memo(i) = true
          }
        }
      }
      memo.last
    }
  }
}
