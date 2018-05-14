package org.mo39.fmbh.algorithm.bitmanipulation

import org.mo39.fmbh.commons.MoTestSuite

class SumOfTwoIntegersTest extends MoTestSuite[SumOfTwoIntegers] {

  g("1 + 1 = 2") { solution =>
    assert(solution.getSum(1, 2) === 1 + 2)
  }

  g("39 + 39 = 78") { solution =>
    assert(solution.getSum(39, 39) === 39 + 39)
  }

  g("integer overflow") { solution =>
    {
      solution match {
        case s: SumOfTwoIntegers.Solution0.type =>
          intercept[NumberFormatException] {
            s.getSum(Int.MaxValue, Int.MaxValue)
          }
        case _ =>
          solution.getSum(Int.MaxValue, Int.MaxValue) === Int.MaxValue + Int.MaxValue
      }
    }
  }
}
