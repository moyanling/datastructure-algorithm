package org.mo39.fmbh.algorithm.bitmanipulation

import org.mo39.fmbh.commons.MoTestSuite

class SingleNumberTest extends MoTestSuite[SingleNumber] {

  g() { solution =>
    assert(solution.singleNumber(Array(3, 7, 3, 39, 2, 1, 2, 1, 7)) === 39)
  }

}
