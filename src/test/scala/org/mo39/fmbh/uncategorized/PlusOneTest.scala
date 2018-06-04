package org.mo39.fmbh.uncategorized

import org.mo39.fmbh.commons.MoTestSuite

class PlusOneTest extends MoTestSuite[PlusOne] {

  g("0") { solution =>
    assert(solution.plusOne(Array(0)) === Array(1))
  }

  g("4,3,2,1") { solution =>
    assert(solution.plusOne(Array(4, 3, 2, 1)) === Array(4, 3, 2, 2))
  }

  g("9,9,9") { solution =>
    assert(solution.plusOne(Array(9, 9, 9)) === Array(1, 0, 0, 0))
  }

}
