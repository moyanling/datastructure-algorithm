package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class RangeAdditionIITest extends MoTestSuite[RangeAdditionII] {

  g("basic") { solution =>
    assert(solution.maxCount(3, 3, Array(Array(2, 2), Array(3, 3))) === 4)
  }

  g("empty") { solution =>
    assert(solution.maxCount(3, 3, Array()) === 9)
  }

}
