package org.mo39.fmbh.algorithm.permutation

import org.mo39.fmbh.commons.MoTestSuite

class LetterCasePermutationTest extends MoTestSuite[LetterCasePermutation] {

  g("a1b2") { solution =>
    assert(solution.letterCasePermutation("a1b2").sorted === List("a1b2", "a1B2", "A1b2", "A1B2").sorted)
  }

  g("empty string") { solution =>
    assert(solution.letterCasePermutation("") === List(""))
  }

}
