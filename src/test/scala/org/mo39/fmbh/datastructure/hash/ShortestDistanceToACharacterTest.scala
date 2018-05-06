package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.MoTestSuite

class ShortestDistanceToACharacterTest
    extends MoTestSuite[ShortestDistanceToACharacter] {

  test() { solution =>
    assert(
      solution.shortestToChar("loveleetcode", 'e') ===
        Array(3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0))
  }

}
