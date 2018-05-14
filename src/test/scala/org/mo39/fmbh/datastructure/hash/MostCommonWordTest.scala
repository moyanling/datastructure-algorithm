package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.MoTestSuite

class MostCommonWordTest extends MoTestSuite[MostCommonWord] {

  g("'ball' is the most common word") { solution =>
    solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", Array("hit")) === "ball"
  }

}
