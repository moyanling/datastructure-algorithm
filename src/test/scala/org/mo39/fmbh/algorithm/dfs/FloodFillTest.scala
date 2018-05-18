package org.mo39.fmbh.algorithm.dfs

import org.mo39.fmbh.commons.MoTestSuite

class FloodFillTest extends MoTestSuite[FloodFill] {

  g("basic") { solution =>
    assert(
      solution
        .floodFill(Array(Array(1, 1, 1), Array(1, 1, 0), Array(1, 0, 1)), 1, 1, 2)
        === Array(Array(2, 2, 2), Array(2, 2, 0), Array(2, 0, 1)))
  }

  g("same old color and new color") { solution =>
    assert(
      solution
        .floodFill(Array(Array(0, 0, 0), Array(0, 1, 0)), 1, 1, 1)
        === Array(Array(0, 0, 0), Array(0, 1, 0)))
  }

}
