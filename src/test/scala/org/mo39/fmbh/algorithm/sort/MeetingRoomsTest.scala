package org.mo39.fmbh.algorithm.sort

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.Interval

class MeetingRoomsTest extends MoTestSuite[MeetingRooms] {

  g() { solution =>
    assert(solution.canAttendMeetings(Array(Interval(0, 30), Interval(5, 10), Interval(15, 20))) === false)
  }

}
