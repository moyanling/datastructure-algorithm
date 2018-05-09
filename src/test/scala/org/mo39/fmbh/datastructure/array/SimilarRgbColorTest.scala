package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite
import org.scalatest.FunSuite

class SimilarRgbColorTest extends MoTestSuite[SimilarRgbColor] {

  test("#09f166") { solution =>
    assert(solution.similarRGB("#09f166") === "#11ee66")
  }

}

class SimilarRgbColorSubTest extends FunSuite {

  test("min function unit test") {
    assert(SimilarRgbColor.Solution.closest("09") === "11")
    assert(SimilarRgbColor.Solution.closest("f1") === "ee")
  }

}
