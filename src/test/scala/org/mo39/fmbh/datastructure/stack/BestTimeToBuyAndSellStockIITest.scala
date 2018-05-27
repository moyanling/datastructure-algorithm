package org.mo39.fmbh.datastructure.stack

import org.mo39.fmbh.commons.MoTestSuite

class BestTimeToBuyAndSellStockIITest extends MoTestSuite[BestTimeToBuyAndSellStockII] {

  g("7, 1, 5, 3, 6, 4") { solution =>
    assert(solution.maxProfit(Array(7, 1, 5, 3, 6, 4)) === 7)
  }

  g("1, 2, 3, 4, 5") { solution =>
    assert(solution.maxProfit(Array(1, 2, 3, 4, 5)) === 4)
  }

  g("7, 6, 4, 3, 1") { solution =>
    assert(solution.maxProfit(Array(7, 6, 4, 3, 1)) === 0)
  }

  g("2, 4, 1") { solution =>
    assert(solution.maxProfit(Array(2, 4, 1)) === 2)
  }

  g("2, 4") { solution =>
    assert(solution.maxProfit(Array(2, 4)) === 2)
  }

  g("empty") { solution =>
    assert(solution.maxProfit(Array.empty) === 0)
  }

}
