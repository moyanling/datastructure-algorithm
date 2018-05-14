package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class SumOfLeftLeavesTest extends MoTestSuite[SumOfLeftLeaves] {

  g() { solution =>
    assert(solution.sumOfLeftLeaves(TreeNode.of("[3,9,20,null,null,15,7]")) === 24)
    assert(solution.sumOfLeftLeaves(TreeNode.of("[1,2,3,4,5]")) === 4)
  }

}
