package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.MoTestSuite

class TwoSumTest extends MoTestSuite[TwoSum] {

  g("2, 7, 11, 15") { solution =>
    assert(solution.twoSum(Array(2, 7, 11, 15), 9) === Array(0, 1))
  }
}
