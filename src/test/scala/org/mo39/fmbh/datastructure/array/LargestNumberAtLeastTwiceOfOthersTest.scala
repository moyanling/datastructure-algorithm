package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class LargestNumberAtLeastTwiceOfOthersTest extends MoTestSuite[LargestNumberAtLeastTwiceOfOthers] {

  g("3, 6, 1, 0") { solution =>
    assert(solution.dominantIndex(Array(3, 6, 1, 0)) === 1)
  }

  g("1, 2, 3, 4") { solution =>
    assert(solution.dominantIndex(Array(1, 2, 3, 4)) === -1)
  }

}
