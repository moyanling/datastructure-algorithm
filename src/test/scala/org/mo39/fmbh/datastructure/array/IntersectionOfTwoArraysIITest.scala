package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class IntersectionOfTwoArraysIITest extends MoTestSuite[IntersectionOfTwoArraysII] {

  g("nums1 = [1, 2, 2, 1], nums2 = [2, 2]") { solution =>
    assert(solution.intersect(Array(1, 2, 1, 2), Array(2, 2)) === Array(2, 2))
  }

  g("nums1 = [-2147483648,1,2,3], nums2 = [1,-2147483648,-2147483648]") { solution =>
    assert(
      solution.intersect(Array(-2147483648, 1, 2, 3), Array(1, -2147483648, -2147483648)).sorted ===
        Array(1, -2147483648).sorted)
  }
}
