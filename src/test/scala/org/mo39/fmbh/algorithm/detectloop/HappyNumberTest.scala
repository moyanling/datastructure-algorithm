package org.mo39.fmbh.algorithm.detectloop

import org.mo39.fmbh.commons.MoTestSuite

class HappyNumberTest extends MoTestSuite[HappyNumber] {

  g("19") { solution =>
    assert(solution.isHappy(19) === true)
  }

  g("2") { solution =>
    assert(solution.isHappy(2) === false)
  }
}
