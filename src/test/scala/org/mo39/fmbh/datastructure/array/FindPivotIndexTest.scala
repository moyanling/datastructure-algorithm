package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class FindPivotIndexTest extends MoTestSuite[FindPivotIndex] {

  g("1, 39, 123, 20, 19, 1") { solution =>
    assert(solution.pivotIndex(Array(1, 39, 123, 20, 19, 1)) === 2)
  }

  g("1, 39, 123, 0, 19") { solution =>
    assert(solution.pivotIndex(Array(1, 39, 123, 20, 19)) === -1)
  }

}
