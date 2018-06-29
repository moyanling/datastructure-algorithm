package org.mo39.fmbh.uncategorized

import org.mo39.fmbh.commons.MoTestSuite

class ArrangingCoinsTest extends MoTestSuite[ArrangingCoins] {

  g(0) { solution =>
    assert(solution.arrangeCoins(0) === 0)
  }

  g(1) { solution =>
    assert(solution.arrangeCoins(1) === 1)
  }

  g(8) { solution =>
    assert(solution.arrangeCoins(8) === 3)
  }

}
