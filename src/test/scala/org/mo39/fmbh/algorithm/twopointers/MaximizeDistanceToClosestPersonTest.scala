package org.mo39.fmbh.algorithm.twopointers

import org.mo39.fmbh.commons.MoTestSuite

class MaximizeDistanceToClosestPersonTest extends MoTestSuite[MaximizeDistanceToClosestPerson] {

  g("[1,0,0,0,1,0,1]") { solution =>
    assert(solution.maxDistToClosest(Array(1, 0, 0, 0, 1, 0, 1)) === 2)
  }

  g("[1,0,0,0]") { solution =>
    assert(solution.maxDistToClosest(Array(1, 0, 0, 0)) === 3)
  }

  g("[0,1]") { solution =>
    assert(solution.maxDistToClosest(Array(0, 1)) === 1)
  }

}
