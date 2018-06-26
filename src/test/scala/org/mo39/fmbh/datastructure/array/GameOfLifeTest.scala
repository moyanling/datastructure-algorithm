package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class GameOfLifeTest extends MoTestSuite[GameOfLife] {

  g() { solution =>
    val board = Array(Array(0, 1, 0), Array(0, 0, 1), Array(1, 1, 1), Array(0, 0, 0))
    solution.gameOfLife(board)
    assert(
      board ===
        Array(Array(0, 0, 0), Array(1, 0, 1), Array(0, 1, 1), Array(0, 1, 0)))
  }

}
