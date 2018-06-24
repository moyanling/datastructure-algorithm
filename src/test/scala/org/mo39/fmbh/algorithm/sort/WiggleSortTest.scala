package org.mo39.fmbh.algorithm.sort

import org.mo39.fmbh.commons.MoTestSuite

class WiggleSortTest extends MoTestSuite[WiggleSort] {

  test("Solution0: 3,5,2,1,6,4") {
    val nums = Array(3, 5, 2, 1, 6, 4)
    WiggleSort.Solution0.wiggleSort(nums)
    assert(nums === Array(1, 3, 2, 5, 4, 6))
  }

  test("Solution1: 3,5,2,1,6,4") {
    val nums = Array(3, 5, 2, 1, 6, 4)
    WiggleSort.Solution1.wiggleSort(nums)
    assert(nums === Array(3, 5, 1, 6, 2, 4))
  }
}
