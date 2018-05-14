package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.MoTestSuite

class CountBinarySubstringsTest extends MoTestSuite[CountBinarySubstrings] {

  g("00110011") { solution =>
    assert(solution.countBinarySubstrings("00110011") === 6)
  }

  g("10101") { solution =>
    assert(solution.countBinarySubstrings("10101") === 4)
  }

  g("10") { solution =>
    assert(solution.countBinarySubstrings("01") === 1)
  }

  g("11") { solution =>
    assert(solution.countBinarySubstrings("11") === 0)
  }

  g("00100") { solution =>
    assert(solution.countBinarySubstrings("00100") === 2)
  }

}
