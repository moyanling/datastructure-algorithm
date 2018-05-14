package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.MoTestSuite

class FindAnagramMappingsTest extends MoTestSuite[FindAnagramMappings] {

  g() { solution =>
    assert(
      solution
        .anagramMappings(Array(12, 28, 46, 32, 50), Array(50, 12, 32, 46, 28))
        === Array(1, 4, 3, 2, 0))
  }

}
