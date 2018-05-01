package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.MoTestSuite

class CountBinarySubstringsTest extends MoTestSuite[CountBinarySubstrings]{

  test("00110011") { solution =>
    assert(solution.countBinarySubstrings("00110011") === 6)
  }

  test("10101") {solution =>
    assert(solution.countBinarySubstrings("10101") === 4)
  }

  test("10") {solution =>
    assert(solution.countBinarySubstrings("01") === 1)
  }

  test("11") {solution =>
    assert(solution.countBinarySubstrings("11") === 0)
  }

  test("00100") {solution =>
    assert(solution.countBinarySubstrings("00100") === 2)
  }

}
