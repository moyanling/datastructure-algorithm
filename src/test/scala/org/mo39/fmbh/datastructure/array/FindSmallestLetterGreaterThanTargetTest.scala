package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class FindSmallestLetterGreaterThanTargetTest extends MoTestSuite[FindSmallestLetterGreaterThanTarget] {

  g("'c', 'f', 'j' > 'g'") { solution =>
    assert(solution.nextGreatestLetter(Array('c', 'f', 'j'), 'g') === 'j')
  }

  g("'c', 'f', 'j' > 'k'") { solution =>
    assert(solution.nextGreatestLetter(Array('c', 'f', 'j'), 'k') === 'c')
  }

}
