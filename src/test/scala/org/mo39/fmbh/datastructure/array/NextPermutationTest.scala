package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.MoTestSuite

class NextPermutationTest extends MoTestSuite[NextPermutation] {

  g("empty") { solution =>
    val nums = Array[Int]()
    solution.nextPermutation(nums)
    assert(nums === Array[Int]())
  }

  g("1") { solution =>
    val nums = Array(1)
    solution.nextPermutation(nums)
    assert(nums === Array(1))
  }

  g("1,2,3") { solution =>
    val nums = Array(1, 2, 3)
    solution.nextPermutation(nums)
    assert(nums === Array(1, 3, 2))
  }

  g("1,3,2") { solution =>
    val nums = Array(1, 3, 2)
    solution.nextPermutation(nums)
    assert(nums === Array(2, 1, 3))
  }

  g("2,3,1") { solution =>
    val nums = Array(2, 3, 1)
    solution.nextPermutation(nums)
    assert(nums === Array(3, 1, 2))
  }

  g("4,2,0,2,3,2,0") { solution =>
    val nums = Array(4, 2, 0, 2, 3, 2, 0)
    solution.nextPermutation(nums)
    assert(nums === Array(4, 2, 0, 3, 0, 2, 2))
  }

  g("1,3,2,4,2,2") { solution =>
    val nums = Array(1, 3, 2, 4, 2, 2)
    solution.nextPermutation(nums)
    assert(nums === Array(1, 3, 4, 2, 2, 2))
  }

  g("1,3,5,4,4,3,2") { solution =>
    val nums = Array(1, 3, 5, 4, 4, 3, 2)
    solution.nextPermutation(nums)
    assert(nums === Array(1, 4, 2, 3, 3, 4, 5))
  }

}
