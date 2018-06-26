package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class SummaryRangesTest extends MoTestSuite[SummaryRanges] {

  g("empty") { solution =>
    assert(solution.summaryRanges(Array.empty) === List.empty)
  }

  g("1") { solution =>
    assert(solution.summaryRanges(Array(1)) === List("1"))
  }

  g("0,2,3,4,6,8,9") { solution =>
    assert(solution.summaryRanges(Array(0, 2, 3, 4, 6, 8, 9)) === List("0", "2->4", "6", "8->9"))
  }

}
