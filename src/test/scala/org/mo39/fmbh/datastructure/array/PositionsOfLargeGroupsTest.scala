package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class PositionsOfLargeGroupsTest extends MoTestSuite[PositionsOfLargeGroups] {

  g("abcdddeeeeaabbbcd") { solution =>
    assert(
      solution.largeGroupPositions("abcdddeeeeaabbbcd") ===
        List(List(3, 5), List(6, 9), List(12, 14)))
  }

  g("abcdddd") { solution =>
    assert(solution.largeGroupPositions("abcdddd") === List(List(3, 6)))
  }

}
