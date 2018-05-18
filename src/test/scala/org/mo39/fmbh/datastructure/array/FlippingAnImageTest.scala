package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class FlippingAnImageTest extends MoTestSuite[FlippingAnImage] {

  g() { solution =>
    assert(solution.flipAndInvertImage(
      Array(Array(1, 1, 0, 0), Array(1, 0, 0, 1), Array(0, 1, 1, 1), Array(1, 0, 1, 0))) === Array(Array(1, 1, 0, 0),
                                                                                                   Array(0, 1, 1, 0),
                                                                                                   Array(0, 0, 0, 1),
                                                                                                   Array(1, 0, 1, 0)))
  }

}
