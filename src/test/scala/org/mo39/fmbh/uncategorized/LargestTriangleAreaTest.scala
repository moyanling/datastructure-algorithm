package org.mo39.fmbh.uncategorized

import org.mo39.fmbh.algorithm.bruteforce.LargestTriangleArea
import org.mo39.fmbh.commons.MoTestSuite
import org.scalactic.Tolerance._

class LargestTriangleAreaTest extends MoTestSuite[LargestTriangleArea] {

  test("basic") { solution =>
    assert(
      solution
        .largestTriangleArea(
          Array(Array(0, 0),
                Array(0, 1),
                Array(1, 0),
                Array(0, 2),
                Array(2, 0))) === 2.0 +- math.pow(10, -6))
  }

  test("complex") { solution =>
    assert(
      solution.largestTriangleArea(
        Array(Array(-35, 19),
              Array(40, 19),
              Array(27, -20),
              Array(35, -3),
              Array(44, 20),
              Array(22, -21),
              Array(35, 33),
              Array(-19, 42),
              Array(11, 47),
              Array(11, 37))) === 1799.0 +- math.pow(10, -6))
  }

  test("really complex one") { solution =>
    assert(
      solution.largestTriangleArea(Array(
        Array(35, -23),
        Array(-12, -48),
        Array(-34, -40),
        Array(21, -25),
        Array(-35, -44),
        Array(24, 1),
        Array(16, -9),
        Array(41, 4),
        Array(-36, -49),
        Array(42, -49),
        Array(-37, -20),
        Array(-35, 11),
        Array(-2, -36),
        Array(18, 21),
        Array(18, 8),
        Array(-24, 14),
        Array(-23, -11),
        Array(-8, 44),
        Array(-19, -3),
        Array(0, -10),
        Array(-21, -4),
        Array(23, 18),
        Array(20, 11),
        Array(-42, 24),
        Array(6, -19)
      )) === 3627.0 +- math.pow(10, -6))
  }

}
