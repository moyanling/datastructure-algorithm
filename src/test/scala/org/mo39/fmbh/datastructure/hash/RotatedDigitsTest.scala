package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.MoTestSuite

class RotatedDigitsTest extends MoTestSuite[RotatedDigits] {

  g("10") { solution =>
    assert(solution.rotatedDigits(10) === 4)
  }

}
