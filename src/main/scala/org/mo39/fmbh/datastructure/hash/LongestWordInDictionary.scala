package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.util.Sorting

/**
  * {{{
  * Given a list of strings words representing an English Dictionary, find
  * the longest word in words that can be built one character at a time by
  * other words in words.  If there is more than one possible answer,
  * return the longest word with the smallest lexicographical order.  If
  * there is no answer, return the empty string.
  *
  * Example 1:
  *
  * Input:
  * words = ["w","wo","wor","worl", "world"]
  * Output: "world"
  * Explanation:
  * The word "world" can be built one character at a time by "w", "wo",
  * "wor", and "worl".
  *
  *
  *
  * Example 2:
  *
  * Input:
  * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
  * Output: "apple"
  * Explanation:
  * Both "apply" and "apple" can be built from other words in the
  * dictionary. However, "apple" is lexicographically smaller than "apply".
  *
  *
  *
  * Note:
  * All the strings in the input will only contain lowercase letters.
  * The length of words will be in the range [1, 1000].
  * The length of words[i] will be in the range [1, 30].
  * }}}
  *
  * @see [[https://leetcode.com/problems/longest-word-in-dictionary/ LongestWordInDictionary]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait LongestWordInDictionary {
  def longestWord(words: Array[String]): String
}

object LongestWordInDictionary extends Enumerable[LongestWordInDictionary] {

  /**
    * This is really awkward,
    * although it's not that much slower than Solution1 on LeetCode
    */
  case object Solution0 extends LongestWordInDictionary {
    override def longestWord(words: Array[String]): String = {
      val groups = words
        .groupBy(_.length)
        .toList
        .sortBy(_._1)
        .map(g => g._1 -> g._2.to[Set])
      val seq = Stream
        .from(0)
        .takeWhile(i => i < groups.length && i + 1 == groups(i)._1)
        .map(groups(_)._2)
      if (seq.isEmpty) return ""
      val canBuid = (s: String, i: Int) => {
        (1 to i).forall(i => groups(i - 1)._2.contains(s.substring(0, i)))
      }
      for (i <- seq.indices.reverse) {
        val result = seq(i).filter(canBuid(_, i))
        if (result.nonEmpty) return result.min
      }
      ""
    }
  }

  case object Solution1 extends LongestWordInDictionary {
    override def longestWord(words: Array[String]): String = {
      var (set, result) = (Set[String](), "")
      Sorting.quickSort(words)
      for (i <- words.indices) {
        val word = words(i)
        if (word.length == 1 ||
            set.contains(word.substring(0, word.length - 1))) {
          set += word
          result = if (word.length > result.length) word else result
        }
      }
      result
    }
  }

}
