package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.MoTestSuite

class BestTimeToBuyAndSellStockTest extends MoTestSuite[BestTimeToBuyAndSellStock] {

  g("empty") { solution =>
    assert(solution.maxProfit(Array.empty) === 0)
  }

  g("7,1,5,3,6,4") { solution =>
    assert(solution.maxProfit(Array(7, 1, 5, 3, 6, 4)) === 5)
  }
}
