package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.MoTestSuite

class StrobogrammaticNumberTest extends MoTestSuite[StrobogrammaticNumber] {

  g("689") { solution =>
    assert(solution.isStrobogrammatic("689") === true)
  }

  g("962") { solution =>
    assert(solution.isStrobogrammatic("962") === false)
  }

}
