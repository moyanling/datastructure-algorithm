package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class RotateStringTest extends MoTestSuite[RotateString] {

  g("A = 'azabc', B = 'bcaza'") { solution =>
    assert(solution.rotateString("azabc", "bcaza") === true)
  }

  g("A = 'abcde', B = 'abced'") { solution =>
    assert(solution.rotateString("abcde", "abced") === false)
  }

  g("empty") { solution =>
    assert(solution.rotateString("", "") === true)
    assert(solution.rotateString("", "a") === false)
  }

}
