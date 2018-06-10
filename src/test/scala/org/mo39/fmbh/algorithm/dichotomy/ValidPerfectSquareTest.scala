package org.mo39.fmbh.algorithm.dichotomy

import org.mo39.fmbh.commons.MoTestSuite

class ValidPerfectSquareTest extends MoTestSuite[ValidPerfectSquare] {

  g("39") { solution =>
    assert(solution.isPerfectSquare(39) === false)
  }

  g("1") { solution =>
    assert(solution.isPerfectSquare(1) === true)
  }

  g("2147395600") { solution =>
    assert(solution.isPerfectSquare(2147395600) === true)
  }

}
