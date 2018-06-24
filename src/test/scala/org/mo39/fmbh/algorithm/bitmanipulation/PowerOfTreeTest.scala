package org.mo39.fmbh.algorithm.bitmanipulation

import org.mo39.fmbh.commons.MoTestSuite

class PowerOfThreeTest extends MoTestSuite[PowerOfThree] {

  g("true") { solution =>
    assert(
      Array(1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721,
        129140163, 387420489, 1162261467).forall(solution.isPowerOfThree))
  }

  g("0") { solution =>
    assert(solution.isPowerOfThree(0) === false)
  }

  g("39") { solution =>
    assert(solution.isPowerOfThree(39) === false)
  }

}
