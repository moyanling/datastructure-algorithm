package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a string, you need to reverse the order of characters in each
  * word within a sentence while still preserving whitespace and initial
  * word order.
  *
  * Example 1:
  *
  * Input: "Let's take LeetCode contest"
  * Output: "s'teL ekat edoCteeL tsetnoc"
  *
  *
  *
  * Note:
  * In the string, each word is separated by single space and there will
  * not be any extra space in the string.
  * }}}
  *
  * @see [[https://leetcode.com/problems/reverse-words-in-a-string-iii/ ReverseWordsInAStringIII]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait ReverseWordsInAStringIII {
  def reverseWords(s: String): String
}

object ReverseWordsInAStringIII extends Enumerable[ReverseWordsInAStringIII] {

  case object Solution extends ReverseWordsInAStringIII {
    override def reverseWords(s: String): String = s.split(' ').map(_.reverse).mkString(" ")
  }

}
