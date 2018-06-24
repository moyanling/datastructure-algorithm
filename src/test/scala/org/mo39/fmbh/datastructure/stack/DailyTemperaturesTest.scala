package org.mo39.fmbh.datastructure.stack

import org.mo39.fmbh.commons.MoTestSuite

class DailyTemperaturesTest extends MoTestSuite[DailyTemperatures] {

  g("73, 74, 75, 71, 69, 72, 76, 73") { solution =>
    assert(solution.dailyTemperatures(Array(73, 74, 75, 71, 69, 72, 76, 73)) === Array(1, 1, 4, 2, 1, 1, 0, 0))
  }

}
