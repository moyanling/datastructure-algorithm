package org.mo39.fmbh.algorithm.twopointers

import org.mo39.fmbh.commons.MoTestSuite

class ReverseVowelsOfAStringTest extends MoTestSuite[ReverseVowelsOfAString] {

  g("hello") { solution =>
    assert(solution.reverseVowels("hello") === "holle")
  }

  g("\"\"") { solution =>
    assert(solution.reverseVowels("") === "")

  }
  g("leetcode") { solution =>
    assert(solution.reverseVowels("leetcode") === "leotcede")
  }
}
