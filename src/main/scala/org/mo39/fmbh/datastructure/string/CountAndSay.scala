package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable

/**
  * {{{
  * The count-and-say sequence is the sequence of integers with the first
  * five terms as following:
  *
  * 1.     1
  * 2.     11
  * 3.     21
  * 4.     1211
  * 5.     111221
  *
  *
  *
  * 1 is read off as "one 1" or 11.
  * 11 is read off as "two 1s" or 21.
  * 21 is read off as "one 2, then one 1" or 1211.
  *
  *
  *
  * Given an integer n, generate the nth term of the count-and-say
  * sequence.
  *
  *
  *
  * Note: Each term of the sequence of integers will be represented as a
  * string.
  *
  *
  * Example 1:
  *
  * Input: 1
  * Output: "1"
  *
  *
  *
  * Example 2:
  *
  * Input: 4
  * Output: "1211"
  * }}}
  *
  * @see [[https://leetcode.com/problems/count-and-say/ CountAndSay]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait CountAndSay {
  def countAndSay(n: Int): String
}

object CountAndSay extends Enumerable[CountAndSay] {
  case object Solution extends CountAndSay {
    override def countAndSay(n: Int): String = {
      val next = (s: String) => {
        val sb = new StringBuilder
        var i  = 0
        for (j <- 0 to s.length if j == s.length || s(j) != s(i)) {
          sb.append(j - i)
          sb.append(s(i))
          i = j
        }
        sb.toString
      }
      var result = "1"
      for (_ <- 1 until n) { result = next(result) }
      result
    }
  }
}
