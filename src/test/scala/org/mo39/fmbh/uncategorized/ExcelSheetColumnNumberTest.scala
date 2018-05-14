package org.mo39.fmbh.uncategorized

import org.mo39.fmbh.commons.MoTestSuite

class ExcelSheetColumnNumberTest extends MoTestSuite[ExcelSheetColumnNumber] {

  g() { solution =>
    assert(solution.titleToNumber("A") === 1)
    assert(solution.titleToNumber("AA") === 27)
    assert(solution.titleToNumber("ZY") === 701)
  }

}
