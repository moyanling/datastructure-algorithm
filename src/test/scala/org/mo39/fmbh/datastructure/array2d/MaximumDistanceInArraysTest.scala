package org.mo39.fmbh.datastructure.array2d

import org.mo39.fmbh.commons.MoTestSuite

class MaximumDistanceInArraysTest extends MoTestSuite[MaximumDistanceInArrays] {

  g("List(List(1, 5), List(2, 4))") { solution =>
    assert(solution.maxDistance(List(List(1, 5), List(2, 4))) === 3)
  }

}
