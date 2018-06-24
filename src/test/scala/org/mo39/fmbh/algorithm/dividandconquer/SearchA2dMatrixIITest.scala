package org.mo39.fmbh.algorithm.dividandconquer

import org.mo39.fmbh.commons.MoTestSuite

class SearchA2dMatrixIITest extends MoTestSuite[SearchA2dMatrixII] {

  g() { solution =>
    assert(
      solution.searchMatrix(Array(Array(1, 4, 7, 11, 15),
                                  Array(2, 5, 8, 12, 19),
                                  Array(3, 6, 9, 16, 22),
                                  Array(10, 13, 14, 17, 24),
                                  Array(18, 21, 23, 26, 30)),
                            20) === false)
  }

}
