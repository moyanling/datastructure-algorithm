package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.MoTestSuite

class MinCostClimbingStairsTest extends MoTestSuite[MinCostClimbingStairs] {

  g("0, 0, 0, 1") { solution =>
    assert(solution.minCostClimbingStairs(Array(0, 0, 0, 1)) === 0)
  }

  g("1, 100, 1, 1, 1, 100, 1, 1, 100, 1") { solution =>
    assert(
      solution
        .minCostClimbingStairs(Array(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)) === 6)
  }

}
