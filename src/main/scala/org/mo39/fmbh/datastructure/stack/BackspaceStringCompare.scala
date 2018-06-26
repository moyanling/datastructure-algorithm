package org.mo39.fmbh.datastructure.stack

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given two strings S and T, return if they are equal when both are typed
  * into empty text editors. # means a backspace character.
  *
  *
  * Example 1:
  *
  *
  * Input: S = "ab#c", T = "ad#c"
  * Output: true
  * Explanation: Both S and T become "ac".
  *
  *
  *
  * Example 2:
  *
  *
  * Input: S = "ab##", T = "c#d#"
  * Output: true
  * Explanation: Both S and T become "".
  *
  *
  *
  * Example 3:
  *
  *
  * Input: S = "a##c", T = "#a#c"
  * Output: true
  * Explanation: Both S and T become "c".
  *
  *
  *
  * Example 4:
  *
  *
  * Input: S = "a#c", T = "b"
  * Output: false
  * Explanation: S becomes "c" while T becomes "b".
  *
  *
  * Note:
  *
  *
  * 	1 <= S.length <= 200
  * 	1 <= T.length <= 200
  * 	S and T only contain lowercase letters and '#' characters.
  *
  *
  * Follow up:
  *
  *
  * 	Can you solve it in O(N) time and O(1) space?
  * }}}
  *
  * @see [[https://leetcode.com/problems/backspace-string-compare/ BackspaceStringCompare]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait BackspaceStringCompare {
  def backspaceCompare(S: String, T: String): Boolean
}

object BackspaceStringCompare extends Enumerable[BackspaceStringCompare] {
  case object Solution0 extends BackspaceStringCompare {
    override def backspaceCompare(S: String, T: String): Boolean = {
      val f = (str: String) => {
        var l = List[Char]()
        for (c <- str) {
          if (c == '#') { if (l.nonEmpty) l = l.tail } else l = c :: l
        }
        l
      }
      f(S) == f(T)
    }
  }

  /**
    * Follow up.
    * Since it's backspace, go from right to left
    */
  case object Solution1 extends BackspaceStringCompare {
    override def backspaceCompare(S: String, T: String): Boolean = {
      var (i, j) = (S.length - 1, T.length - 1)
      val next = (x: Int, str: String) => {
        var (i, count) = (x, 0)
        while (i >= 0 && !(count == 0 && str(i) != '#')) {
          if (str(i) != '#') count -= 1
          else count += 1
          i -= 1
        }
        i
      }
      while (i >= 0 || j >= 0) {
        i = next(i, S)
        j = next(j, T)
        if (i == -1 || j == -1) return j == i
        else if (S(i) != T(j)) return false
        else { i -= 1; j -= 1 }
      }
      true
    }
  }
}
