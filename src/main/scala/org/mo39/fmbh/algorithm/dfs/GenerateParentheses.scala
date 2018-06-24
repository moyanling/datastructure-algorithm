package org.mo39.fmbh.algorithm.dfs

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  *
  * Given n pairs of parentheses, write a function to generate all
  * combinations of well-formed parentheses.
  *
  *
  *
  * For example, given n = 3, a solution set is:
  *
  *
  * [
  *   "((()))",
  *   "(()())",
  *   "(())()",
  *   "()(())",
  *   "()()()"
  * ]
  * }}}
  *
  * @see [[https://leetcode.com/problems/generate-parentheses/ GenerateParentheses]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait GenerateParentheses {
  def generateParenthesis(n: Int): List[String]
}

object GenerateParentheses extends Enumerable[GenerateParentheses] {
  case object Solution extends GenerateParentheses {
    override def generateParenthesis(n: Int): List[String] = {
      var result = List[String]()
      def dfs(s: String, left: Int, right: Int): Unit =
        if (left <= 0 && right <= 0) result = s :: result
        else {
          if (left > 0) dfs(s + "(", left - 1, right)
          if (right > 0 && right != left) dfs(s + ")", left, right - 1)
        }
      dfs("", n, n)
      result
    }
  }
}
