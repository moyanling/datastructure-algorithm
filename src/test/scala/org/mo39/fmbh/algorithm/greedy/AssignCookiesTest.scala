package org.mo39.fmbh.algorithm.greedy

import org.mo39.fmbh.commons.MoTestSuite

class AssignCookiesTest extends MoTestSuite[AssignCookies] {

  g() { solution =>
    assert(solution.findContentChildren(Array(1, 2, 3), Array(1, 1)) === 1)
    assert(solution.findContentChildren(Array(1, 2, 3), Array.empty) === 0)
    assert(solution.findContentChildren(Array(1, 2), Array(1, 2, 3)) === 2)
  }
}
