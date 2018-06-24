package org.mo39.fmbh.datastructure.stack

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a string containing just the characters '(', ')', '{', '}', '['
  * and ']', determine if the input string is valid.
  *
  * An input string is valid if:
  *
  *
  * 	Open brackets must be closed by the same type of brackets.
  * 	Open brackets must be closed in the correct order.
  *
  *
  * Note that an empty string is also considered valid.
  *
  * Example 1:
  *
  *
  * Input: "()"
  * Output: true
  *
  *
  * Example 2:
  *
  *
  * Input: "()[]{}"
  * Output: true
  *
  *
  * Example 3:
  *
  *
  * Input: "(]"
  * Output: false
  *
  *
  * Example 4:
  *
  *
  * Input: "([)]"
  * Output: false
  *
  *
  * Example 5:
  *
  *
  * Input: "{[]}"
  * Output: true
  * }}}
  *
  * @see [[https://leetcode.com/problems/valid-parentheses/ ValidParentheses]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait ValidParentheses {
  def isValid(s: String): Boolean
}

object ValidParentheses extends Enumerable[ValidParentheses] {
  case object Solution extends ValidParentheses {
    override def isValid(s: String): Boolean = {
      val l     = Set('(', '{', '[')
      val r     = Map(')' -> '(', '}' -> '{', ']' -> '[')
      var stack = List[Char]()
      for (c <- s) {
        if (l.contains(c)) stack = c :: stack
        else {
          if (stack.isEmpty || stack.head != r(c)) return false
          stack = stack.tail
        }
      }
      stack.isEmpty
    }
  }
}
