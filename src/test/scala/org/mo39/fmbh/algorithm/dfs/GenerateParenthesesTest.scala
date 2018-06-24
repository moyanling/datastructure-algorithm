package org.mo39.fmbh.algorithm.dfs

import org.mo39.fmbh.commons.MoTestSuite

class GenerateParenthesesTest extends MoTestSuite[GenerateParentheses] {

  g(3) { solution =>
    assert(solution.generateParenthesis(3) === Array("((()))", "(()())", "(())()", "()(())", "()()()").reverse)
  }

}
