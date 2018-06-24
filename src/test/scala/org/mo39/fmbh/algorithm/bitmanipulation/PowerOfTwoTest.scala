package org.mo39.fmbh.algorithm.bitmanipulation

import org.mo39.fmbh.commons.MoTestSuite

class PowerOfTwoTest extends MoTestSuite[PowerOfTwo] {

  g("true") { solution =>
    Array(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288,
      1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912).foreach(
      i => assert(solution.isPowerOfTwo(i) === true)
    )
  }

  g("39") { solution =>
    assert(solution.isPowerOfTwo(39) === false)
  }

  g("0") { solution =>
    assert(solution.isPowerOfTwo(0) === false)
  }

}
