package org.mo39.fmbh.algorithm.math

import org.mo39.fmbh.commons.MoTestSuite

class PascalsTriangleIITest extends MoTestSuite[PascalsTriangleII] {

  g("0") { solution =>
    assert(solution.getRow(0) === List(1))
  }

  g("3") { solution =>
    assert(solution.getRow(3) === List(1, 3, 3, 1))
  }

}
