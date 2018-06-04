package org.mo39.fmbh.algorithm.twopointers

import org.mo39.fmbh.commons.MoTestSuite

class RemoveElementTest extends MoTestSuite[RemoveElement] {

  g("nums = [0,1,2,2,3,0,4,2], val = 2,") { solution =>
    val nums = Array(0, 1, 2, 2, 3, 0, 4, 2)
    assert(solution.removeElement(nums, 2) === 5)
    assert(nums.take(5) === Array(0, 1, 3, 0, 4))
  }
}
