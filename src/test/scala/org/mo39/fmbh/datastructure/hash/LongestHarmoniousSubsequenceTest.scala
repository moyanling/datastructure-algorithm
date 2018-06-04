package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.MoTestSuite

class LongestHarmoniousSubsequenceTest extends MoTestSuite[LongestHarmoniousSubsequence] {

  g() { solution =>
    assert(solution.findLHS(Array(1, 3, 2, 2, 5, 2, 3, 7)) === 5)
  }
}
