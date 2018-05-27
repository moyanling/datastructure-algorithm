package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.MoTestSuite

class ReverseStringIITest extends MoTestSuite[ReverseStringII] {
  g("'abcdefg', 2") { solution =>
    assert(solution.reverseStr("abcdefg", 2) === "bacdfeg")
  }
}
