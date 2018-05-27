package org.mo39.fmbh.algorithm.sort

import org.mo39.fmbh.commons.MoTestSuite

class MaximumProductOfThreeNumbersTest extends MoTestSuite[MaximumProductOfThreeNumbers] {

  g("-2, -1, 0, 1, 2") { solution =>
    assert(solution.maximumProduct(Array(-2, -1, 0, 1, 2)) === 4)
  }

  g("-2, -1, 0, 1, 2, 3") { solution =>
    assert(solution.maximumProduct(Array(-2, -1, 0, 1, 2, 3)) === 6)
  }

  g("-3, -2, -1, 0") { solution =>
    assert(solution.maximumProduct(Array(-3, -2, -1, 0)) === 0)
  }

}
