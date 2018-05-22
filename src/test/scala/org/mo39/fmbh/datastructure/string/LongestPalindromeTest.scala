package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.MoTestSuite

class LongestPalindromeTest extends MoTestSuite[LongestPalindrome] {

  g("abccccdd") {solution =>
    assert(solution.longestPalindrome("abccccdd") === 7)
  }

  g("ccc") {solution =>
    assert(solution.longestPalindrome("ccc") === 3)
  }

  g("cccbbb") {solution =>
    assert(solution.longestPalindrome("cccbbb") === 5)
  }

}
