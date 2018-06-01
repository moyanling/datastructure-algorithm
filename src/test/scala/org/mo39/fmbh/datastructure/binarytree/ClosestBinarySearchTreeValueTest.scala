package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class ClosestBinarySearchTreeValueTest extends MoTestSuite[ClosestBinarySearchTreeValue] {

  g("[4,2,5,1,3], 3.7") { solution =>
    assert(solution.closestValue(TreeNode.of("[4,2,5,1,3]"), 3.7) === 4)
  }

  g("[1500000000,1400000000], -1500000000.0") { solution =>
    assert(solution.closestValue(TreeNode.of("[1500000000,1400000000]"), -1500000000.0) === 1400000000)
  }

  g("complex one") { solution =>
    assert(
      solution.closestValue(
        TreeNode.of(
          "[41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23]"),
        3.285714
      ) === 3)
  }
}
