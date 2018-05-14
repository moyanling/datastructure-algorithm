package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  *
  * Given a list of sorted characters letters containing only lowercase
  * letters, and given a target letter target, find the smallest element in
  * the list that is larger than the given target.
  *
  * Letters also wrap around.  For example, if the target is target = 'z'
  * and letters = ['a', 'b'], the answer is 'a'.
  *
  *
  * Examples:
  *
  * Input:
  * letters = ["c", "f", "j"]
  * target = "a"
  * Output: "c"
  *
  * Input:
  * letters = ["c", "f", "j"]
  * target = "c"
  * Output: "f"
  *
  * Input:
  * letters = ["c", "f", "j"]
  * target = "d"
  * Output: "f"
  *
  * Input:
  * letters = ["c", "f", "j"]
  * target = "g"
  * Output: "j"
  *
  * Input:
  * letters = ["c", "f", "j"]
  * target = "j"
  * Output: "c"
  *
  * Input:
  * letters = ["c", "f", "j"]
  * target = "k"
  * Output: "c"
  *
  *
  *
  * Note:
  *
  * letters has a length in range [2, 10000].
  * letters consists of lowercase letters, and contains at least 2 unique
  * letters.
  * target is a lowercase letter.
  * }}}
  *
  * @see [[https://leetcode.com/problems/find-smallest-letter-greater-than-target/ FindSmallestLetterGreaterThanTarget]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait FindSmallestLetterGreaterThanTarget {
  def nextGreatestLetter(letters: Array[Char], target: Char): Char
}

object FindSmallestLetterGreaterThanTarget extends Enumerable[FindSmallestLetterGreaterThanTarget] {
  case object Solution extends FindSmallestLetterGreaterThanTarget {
    override def nextGreatestLetter(letters: Array[Char], target: Char): Char = {
      val arr = letters.filter(_ > target)
      if (arr.length > 0) arr.min else letters.min
    }
  }
}
