package org.mo39.fmbh.algorithm.greedy

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.Interval

class MeetingRoomsIITest extends MoTestSuite[MeetingRoomsII] {

  g("[[7,10],[2,4]]") { solution =>
    assert(solution.minMeetingRooms(Array(Interval(7, 10), Interval(2, 4))) === 1)
  }

  g("[[9,10],[4,9],[4,17]]") { solution =>
    assert(solution.minMeetingRooms(Array(Interval(9, 10), Interval(4, 9), Interval(4, 17))) === 2)
  }

}
