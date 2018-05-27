package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class StudentAttendanceRecordITest extends MoTestSuite[StudentAttendanceRecordI] {

  g("PPALLP") { solution =>
    assert(solution.checkRecord("PPALLP") === true)
  }

  g("PPALLL") { solution =>
    assert(solution.checkRecord("PPALLL") === false)
  }

}
