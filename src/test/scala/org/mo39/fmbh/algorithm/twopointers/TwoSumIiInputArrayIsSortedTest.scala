package org.mo39.fmbh.algorithm.twopointers

import org.mo39.fmbh.commons.MoTestSuite

class TwoSumIiInputArrayIsSortedTest extends MoTestSuite[TwoSumIiInputArrayIsSorted] {

  g() { solution =>
    assert(solution.twoSum(Array(2, 7, 11, 15), 9) === Array(1, 2))
  }

}
