package org.mo39.fmbh.algorithm.dichotomy

import org.mo39.fmbh.commons.MoTestSuite

class SearchInsertPositionTest extends MoTestSuite[SearchInsertPosition] {

  g("[1,3,5,6], 5") { solution =>
    assert(solution.searchInsert(Array(1, 3, 5, 6), 5) === 2)
  }

  g("[1,3,5,6], 2") { solution =>
    assert(solution.searchInsert(Array(1, 3, 5, 6), 2) === 1)
  }

  g("[1,3,5,6], 7") { solution =>
    assert(solution.searchInsert(Array(1, 3, 5, 6), 7) === 4)
  }

  g("[1,3,4,5,6], 7") { solution =>
    assert(solution.searchInsert(Array(1, 3, 4, 5, 6), 7) === 5)
  }

  g("[1,3,5,6], 0") { solution =>
    assert(solution.searchInsert(Array(1, 3, 5, 6), 0) === 0)
  }

}
