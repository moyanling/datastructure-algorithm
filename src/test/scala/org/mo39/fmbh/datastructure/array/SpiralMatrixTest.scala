package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class SpiralMatrixTest extends MoTestSuite[SpiralMatrix] {

  g("[[1],[2],[3],[4],[5],[6],[7],[8],[9],[10]]") { solution =>
    assert(
      solution.spiralOrder(Array(Array(1),
                                 Array(2),
                                 Array(3),
                                 Array(4),
                                 Array(5),
                                 Array(6),
                                 Array(7),
                                 Array(8),
                                 Array(9),
                                 Array(10))) === List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
  }

}
