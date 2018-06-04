package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.MoTestSuite

class PascalsTriangleTest extends MoTestSuite[PascalsTriangle] {

  g("5") { solution =>
    assert(solution.generate(5) === List(List(1), List(1, 1), List(1, 2, 1), List(1, 3, 3, 1), List(1, 4, 6, 4, 1)))
  }

}
