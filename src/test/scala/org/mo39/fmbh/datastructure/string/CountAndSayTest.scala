package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.MoTestSuite

class CountAndSayTest extends MoTestSuite[CountAndSay] {

  g(4) { solution =>
    assert(solution.countAndSay(4) === "1211")
  }

  g(5) { solution =>
    assert(solution.countAndSay(5) === "111221")
  }

}
