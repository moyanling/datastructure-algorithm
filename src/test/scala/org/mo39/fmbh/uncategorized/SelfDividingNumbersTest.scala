package org.mo39.fmbh.uncategorized

import org.mo39.fmbh.commons.MoTestSuite

class SelfDividingNumbersTest extends MoTestSuite[SelfDividingNumbers] {

  g("1 to 22") { solution =>
    assert(
      solution.selfDividingNumbers(1, 22) ===
        List(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22))
  }

}
