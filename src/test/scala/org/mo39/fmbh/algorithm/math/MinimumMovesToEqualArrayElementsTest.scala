package org.mo39.fmbh.algorithm.math

import org.mo39.fmbh.commons.MoTestSuite

class MinimumMovesToEqualArrayElementsTest extends MoTestSuite[MinimumMovesToEqualArrayElements] {

  g() { solution =>
    assert(solution.minMoves(Array(1, 2, 3)) === 3)
  }

}
