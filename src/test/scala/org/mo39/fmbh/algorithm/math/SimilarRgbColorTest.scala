package org.mo39.fmbh.algorithm.math

import org.mo39.fmbh.commons.MoTestSuite
import org.scalatest.FunSuite

class SimilarRgbColorTest extends MoTestSuite[SimilarRgbColor] {

  test("#09f166") { solution =>
    assert(solution.similarRGB("#09f166") === "#11ee66")
  }

}

class SimilarRgbColorSubTest extends FunSuite {

  test("min function unit test") {
    assert(SimilarRgbColor.Solution.min(Seq(0, 9)) === 1)
    assert(SimilarRgbColor.Solution.min(Seq(1, 10)) === 3)
    assert(SimilarRgbColor.Solution.min(Seq(15, 12)) === 13)
  }

}
