package org.mo39.fmbh.datastructure.stack

import org.mo39.fmbh.commons.MoTestSuite

class ValidParenthesesTest extends MoTestSuite[ValidParentheses] {

  g("[]{()}") { solution =>
    assert(solution.isValid("[]{()}") === true)
  }

  g("[]{()}}") { solution =>
    assert(solution.isValid("[]{()}}") === false)
  }

  g("(]") { solution =>
    assert(solution.isValid("(]") === false)
  }

}
