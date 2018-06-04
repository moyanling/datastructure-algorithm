package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.MoTestSuite

class MaximumSubarrayTest extends MoTestSuite[MaximumSubarray] {

  g("[-2,1,-3,4,-1,2,1,-5,4]") { solution =>
    assert(solution.maxSubArray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)) === 6)
  }

}
