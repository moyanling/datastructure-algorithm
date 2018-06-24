package org.mo39.fmbh.algorithm.twopointers

import org.mo39.fmbh.commons.MoTestSuite

class TrappingRainWaterTest extends MoTestSuite[TrappingRainWater] {

  g("[0,1,0,2,1,0,1,3,2,1,2,1]") { solution =>
    assert(solution.trap(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) === 6)
  }

}
