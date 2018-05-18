package org.mo39.fmbh.algorithm.permutation

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a string S, we can transform every letter individually to be
  * lowercase or uppercase to create another string.  Return a list of all
  * possible strings we could create.
  *
  *
  * Examples:
  * Input: S = "a1b2"
  * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
  *
  * Input: S = "3z4"
  * Output: ["3z4", "3Z4"]
  *
  * Input: S = "12345"
  * Output: ["12345"]
  *
  *
  * Note:
  *
  *
  * 	S will be a string with length at most 12.
  * 	S will consist only of letters or digits.
  * }}}
  *
  * @see [[https://leetcode.com/problems/letter-case-permutation/ LetterCasePermutation]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait LetterCasePermutation {
  def letterCasePermutation(S: String): List[String]
}

object LetterCasePermutation extends Enumerable[LetterCasePermutation] {

  /**
    * The result is a list of String.
    * Although using list of Char array might be faster, the code does not look nice and clean.
    * In addition, array has to be taken carefully when doing copy.
    */
  case object Solution0 extends LetterCasePermutation {
    override def letterCasePermutation(S: String): List[String] = {
      if (S == "") return List("")
      var result = List[String]()
      if (S(0).isDigit) result = S(0).toString +: result
      else result ++= List(S(0).toUpper.toString, S(0).toLower.toString)
      for (i <- 1 until S.length) {
        result =
          if (S(i).isDigit) result.map(_ + S(i))
          else result.map(_ + S(i).toUpper) ++ result.map(_ + S(i).toLower)
      }
      result
    }
  }

  /**
    * This solution improves the previous one with a pretty nice trick.
    */
  case object Solution1 extends LetterCasePermutation {
    override def letterCasePermutation(S: String): List[String] = {
      var result = List[String]("")
      for (i <- S.indices) {
        result =
          if (S(i).isDigit) result.map(_ + S(i))
          else result.map(_ + S(i).toUpper) ++ result.map(_ + S(i).toLower)
      }
      result
    }
  }

}
