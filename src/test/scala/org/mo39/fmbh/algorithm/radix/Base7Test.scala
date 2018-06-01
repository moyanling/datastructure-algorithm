package org.mo39.fmbh.algorithm.radix

import org.mo39.fmbh.commons.MoTestSuite

class Base7Test extends MoTestSuite[Base7] {
  g("100") { solution =>
    assert(solution.convertToBase7(100) === "202")
  }

  g("-7") { solution =>
    assert(solution.convertToBase7(-7) === "-10")
  }

  g("0") { solution =>
    assert(solution.convertToBase7(0) === "0")
  }
}
