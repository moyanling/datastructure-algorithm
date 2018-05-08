package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.MoTestSuite

class IntersectionOfTwoArraysTest extends MoTestSuite[IntersectionOfTwoArrays ]{

  test() {solution =>
    assert(solution.intersection(Array(1,2,2,1), Array(2,2)) === Array(2))
  }

}
