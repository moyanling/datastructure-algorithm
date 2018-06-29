package org.mo39.fmbh.algorithm.twopointers

import org.mo39.fmbh.commons.MoTestSuite

class StringCompressionTest extends MoTestSuite[StringCompression] {

  g("Array('a', 'a', 'a', 'b', 'b', 'a', 'a')") { solution =>
    val chars = Array('a', 'a', 'a', 'b', 'b', 'a', 'a')
    assert(solution.compress(chars) === 6)
    assert(chars.take(6) === Array('a', '3', 'b', '2', 'a', '2'))
  }

}
