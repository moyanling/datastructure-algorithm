package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a set of keywords words and a string S, make all appearances of all keywords in S bold.
  * Any letters between <b> and </b> tags become bold.
  *
  * The returned string should use the least number of tags possible,
  * and of course the tags should form a valid combination.
  *
  * For example, given that words = ["ab", "bc"] and S = "aabcd",
  * we should return "a<b>abc</b>d".
  * Note that returning "a<b>a<b>b</b>c</b>d" would use more tags, so it is incorrect.
  *
  * Note:
  *
  * words has length in range [0, 50].
  * words[i] has length in range [1, 10].
  * S has length in range [0, 500].
  * All characters in words[i] and S are lowercase letters.
  * }}}
  *
  * @see [[https://leetcode.com/problems/bold-words-in-string/ BoldWordsInString]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait BoldWordsInString {
  def boldWords(words: Array[String], S: String): String
}

object BoldWordsInString extends Enumerable[BoldWordsInString] {
  case object Solution extends BoldWordsInString {
    override def boldWords(words: Array[String], S: String): String = {
      val ws   = words.sortBy(_.length)
      val mark = Array.fill(S.length) { false }
      for (i <- S.indices) {
        val j = ws.lastIndexWhere(S.substring(i).startsWith)
        if (j != -1) for (l <- 1 to ws(j).length) mark(i + l - 1) = true
      }
      val buf   = S.toCharArray.toBuffer
      var found = false
      for (i <- S.indices.reverse) {
        if (mark(i) && !found) {
          found = true
          buf.insert(i + 1, "</b>".toList: _*)
        } else if (!mark(i) && found) {
          found = false
          buf.insert(i + 1, "<b>".toList: _*)
        }
      }
      if (found) buf.insert(0, "<b>".toList: _*)
      buf.mkString
    }
  }
  case object Solution1 extends BoldWordsInString {
    override def boldWords(words: Array[String], S: String): String = {
      val mark = Array.fill(S.length + 1) { 0 }
      for (w <- words; i <- S.indices if S.startsWith(w, i)) {
        mark(i) += 1
        mark(i + w.length) -= 1
      }
      var sum, pre = 0
      val sb       = new StringBuilder
      for (i <- 0 to S.length) {
        sum += mark(i)
        if (mark(i) > 0 && pre == 0) sb.append("<b>")
        if (pre > 0 && sum == 0) sb.append("</b>")
        if (i < S.length) sb.append(S(i))
        pre = sum
      }
      sb.toString
    }
  }

}
