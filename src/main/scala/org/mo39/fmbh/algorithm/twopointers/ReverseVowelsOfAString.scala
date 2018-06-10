package org.mo39.fmbh.algorithm.twopointers

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Write a function that takes a string as input and reverse only the
  * vowels of a string.
  *
  *
  * Example 1:
  * Given s = "hello", return "holle".
  *
  *
  *
  * Example 2:
  * Given s = "leetcode", return "leotcede".
  *
  *
  *
  * Note:
  * The vowels does not include the letter "y".
  * }}}
  *
  * @see [[https://leetcode.com/problems/reverse-vowels-of-a-string/ ReverseVowelsOfAString]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait ReverseVowelsOfAString {
  def reverseVowels(s: String): String
}

object ReverseVowelsOfAString extends Enumerable[ReverseVowelsOfAString] {
  case object Solution extends ReverseVowelsOfAString {
    override def reverseVowels(s: String): String = {
      val vowels = Set('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
      val arr    = s.toCharArray
      var (i, j) = (0, arr.length - 1)
      while (i < j) {
        if (!vowels.contains(arr(i))) i += 1
        if (!vowels.contains(arr(j))) j -= 1
        if (vowels.contains(arr(i)) && vowels.contains(arr(j))) {
          if (arr(i) != arr(j)) {
            val tmp = arr(i)
            arr(i) = arr(j)
            arr(j) = tmp
          }
          i += 1; j -= 1
        }
      }
      arr.mkString
    }
  }
}
