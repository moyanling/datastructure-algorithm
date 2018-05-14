package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class FindAllNumbersDisappearedInAnArrayTest extends MoTestSuite[FindAllNumbersDisappearedInAnArray] {

  g("4, 3, 2, 7, 8, 2, 3, 1") { solution =>
    assert(
      solution
        .findDisappearedNumbers(Array(4, 3, 2, 7, 8, 2, 3, 1)) === List(5, 6))
  }

}
