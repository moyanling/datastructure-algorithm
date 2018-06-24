package org.mo39.fmbh.algorithm.sort

import org.mo39.fmbh.commons.MoTestSuite

class QueueReconstructionByHeightTest extends MoTestSuite[QueueReconstructionByHeight] {

  g("[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]") { solution =>
    assert(solution.reconstructQueue(
      Array(Array(7, 0), Array(4, 4), Array(7, 1), Array(5, 0), Array(6, 1), Array(5, 2))) === Array(Array(5, 0),
                                                                                                     Array(7, 0),
                                                                                                     Array(5, 2),
                                                                                                     Array(6, 1),
                                                                                                     Array(4, 4),
                                                                                                     Array(7, 1)))
  }

}
