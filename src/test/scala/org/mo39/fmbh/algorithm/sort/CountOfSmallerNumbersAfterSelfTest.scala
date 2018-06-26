package org.mo39.fmbh.algorithm.sort

import org.mo39.fmbh.commons.MoTestSuite

class CountOfSmallerNumbersAfterSelfTest extends MoTestSuite[CountOfSmallerNumbersAfterSelf] {

  g("Array(5, 2, 6, 1)") { solution =>
    assert(solution.countSmaller(Array(5, 2, 6, 1)) === List(2, 1, 1, 0))
  }

}
