package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class DegreeOfAnArrayTest extends MoTestSuite[DegreeOfAnArray] {

  test("1, 2, 2, 3, 1") { solution =>
    assert(solution.findShortestSubArray(Array(1, 2, 2, 3, 1)) === 2)
  }

  test("1, 2, 2, 3, 1, 4, 2") { solution =>
    assert(solution.findShortestSubArray(Array(1, 2, 2, 3, 1, 4, 2)) === 6)
  }
}
