package org.mo39.fmbh.algorithm.dfs

import org.mo39.fmbh.commons.MoTestSuite

class LongestAbsoluteFilePathTest extends MoTestSuite[LongestAbsoluteFilePath] {

  g("simple") { solution =>
    assert(solution.lengthLongestPath("dir\n    file.txt") === 12)
  }

  g("complex") { solution =>
    assert(
      solution.lengthLongestPath(
        "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext") === 32)
  }

}
