package org.mo39.fmbh.algorithm.bitmanipulation

import org.mo39.fmbh.commons.MoTestSuite

class BinaryNumberWithAlternatingBitsTest extends MoTestSuite[BinaryNumberWithAlternatingBits] {

  g("number 341 has alternating bits") { solution =>
    solution.hasAlternatingBits(341) === true
  }

  g("number 39 does not have alternating bits") { solution =>
    solution.hasAlternatingBits(39) === false
  }

}
