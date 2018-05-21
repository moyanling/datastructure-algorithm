package org.mo39.fmbh.algorithm.permutation

import org.mo39.fmbh.commons.MoTestSuite

class NumberOfBoomerangsTest extends MoTestSuite[NumberOfBoomerangs] {

  g("[[0,0],[1,0],[2,0]]") { solution =>
    assert(solution.numberOfBoomerangs(Array(Array(0, 0), Array(1, 0), Array(2, 0))) === 2)
  }

  g("[[0,0],[1,0],[0,2],[1,2]]") { solution =>
    assert(solution.numberOfBoomerangs(Array(Array(0, 0), Array(1, 0), Array(0, 2), Array(1, 2))) === 0)
  }

}
