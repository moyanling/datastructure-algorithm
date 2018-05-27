package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.MoTestSuite

class PaintHouseTest extends MoTestSuite[PaintHouse] {

  g("[[17,2,17],[16,16,5],[14,3,19]]") { solution =>
    assert(solution.minCost(Array(Array(17, 2, 17), Array(16, 16, 5), Array(14, 3, 19))) === 10)
  }

  g("[[3,5,3],[6,17,6],[7,13,18],[9,10,18]]") { solution =>
    assert(solution.minCost(Array(Array(3, 5, 3), Array(6, 17, 6), Array(7, 13, 18), Array(9, 10, 18))) === 26)
  }

}
