package org.mo39.fmbh.algorithm.combination

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a string containing digits from 2-9 inclusive, return all
  * possible letter combinations that the number could represent.
  *
  * A mapping of digit to letters (just like on the telephone buttons) is
  * given below. Note that 1 does not map to any letters.
  *
  *
  *
  * Example:
  *
  *
  * Input: "23"
  * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
  *
  *
  * Note:
  *
  * Although the above answer is in lexicographical order, your answer
  * could be in any order you want.
  * }}}
  *
  * @see [[https://leetcode.com/problems/letter-combinations-of-a-phone-number/ LetterCombinationsOfAPhoneNumber]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait LetterCombinationsOfAPhoneNumber {
  def letterCombinations(digits: String): List[String]
}

object LetterCombinationsOfAPhoneNumber extends Enumerable[LetterCombinationsOfAPhoneNumber] {

  val map =
    Map('2' -> "abc",
        '3' -> "def",
        '4' -> "ghi",
        '5' -> "jkl",
        '6' -> "mno",
        '7' -> "pqrs",
        '8' -> "tuv",
        '9' -> "wxyz")
      .mapValues(_.toList)

  case object Solution extends LetterCombinationsOfAPhoneNumber {
    override def letterCombinations(digits: String): List[String] = {
      if (digits.isEmpty) return Nil
      var result = List("")
      for (c <- digits) {
        result = map(c).flatMap(letter => result.map(_ + letter))
      }
      result
    }
  }

}
