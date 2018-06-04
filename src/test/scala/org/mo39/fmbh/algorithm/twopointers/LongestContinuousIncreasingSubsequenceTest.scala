package org.mo39.fmbh.algorithm.twopointers

import org.mo39.fmbh.commons.MoTestSuite

class LongestContinuousIncreasingSubsequenceTest extends MoTestSuite[LongestContinuousIncreasingSubsequence] {

  g("1,3,5,4,7") { solution =>
    assert(solution.findLengthOfLCIS(Array(1, 3, 5, 4, 7)) === 3)
  }

  g("2,2,2,2") { solution =>
    assert(solution.findLengthOfLCIS(Array(2, 2, 2, 2)) === 1)
  }
}
