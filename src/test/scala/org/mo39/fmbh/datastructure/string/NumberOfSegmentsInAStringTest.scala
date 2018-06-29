package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.MoTestSuite

class NumberOfSegmentsInAStringTest extends MoTestSuite[NumberOfSegmentsInAString] {

  g(", , , ,        a, eaefa") { solution =>
    assert(solution.countSegments(", , , ,        a, eaefa") === 6)
  }

}
