package org.mo39.fmbh.datastructure.stack

import org.mo39.fmbh.commons.MoTestSuite

class BackspaceStringCompareTest extends MoTestSuite[BackspaceStringCompare] {

  g("S = \"a##c\", T = \"#a#c\"") { solution =>
    assert(solution.backspaceCompare("a##c", "#a#c") === true)
  }

  g("S = \"a#c\", T = \"b\"") { solution =>
    assert(solution.backspaceCompare("a#c", "b") === false)
  }

}
