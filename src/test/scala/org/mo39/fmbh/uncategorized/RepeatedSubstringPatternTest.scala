package org.mo39.fmbh.uncategorized

import org.mo39.fmbh.commons.MoTestSuite

class RepeatedSubstringPatternTest extends MoTestSuite[RepeatedSubstringPattern] {

  g("abcabcabcabcabcabc") { solution =>
    assert(solution.repeatedSubstringPattern("abcabcabcabcabcabc") === true)
  }

  g("abcabcacabcabcabc") { solution =>
    assert(solution.repeatedSubstringPattern("abcabcacabcabcabc") === false)
  }

}
