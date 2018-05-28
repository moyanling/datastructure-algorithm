package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.MoTestSuite

class ClimbingStairsTest extends MoTestSuite[ClimbingStairs] {
  g("3") { solution =>
    assert(solution.climbStairs(3) === 3)
  }
  g("10") { solution =>
    assert(solution.climbStairs(10) === 89)
  }
}
