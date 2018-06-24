package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.MoTestSuite

class HouseRobberTest extends MoTestSuite[HouseRobber] {

  g("[1,2,3,1]") { solution =>
    assert(solution.rob(Array(1, 2, 3, 1)) === 4)
  }

  g("[2,7,9,3,1]") { solution =>
    assert(solution.rob(Array(2, 7, 9, 3, 1)) === 12)
  }

}
