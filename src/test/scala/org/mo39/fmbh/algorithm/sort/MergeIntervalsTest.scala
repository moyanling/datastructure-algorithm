package org.mo39.fmbh.algorithm.sort

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.Interval

class MergeIntervalsTest extends MoTestSuite[MergeIntervals] {

  g() { solution =>
    assert(
      solution.merge(List(Interval(1, 4), Interval(0, 2), Interval(3, 5))).sortBy(_.start) === List(Interval(0, 5))
        .sortBy(_.start))
  }

}
