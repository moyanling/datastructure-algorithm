package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class MinimumDistanceBetweenBstNodesTest extends MoTestSuite[MinimumDistanceBetweenBstNodes] {

  g("[1,null,3,2]") { solution =>
    assert(solution.minDiffInBST(TreeNode.of("[1,null,3,2]")) === 1)
  }

  g("[1,null,2]") { solution =>
    assert(solution.minDiffInBST(TreeNode.of("[1,null,2]")) === 1)
  }

  g("[236,104,null,null,227]") { solution =>
    assert(solution.minDiffInBST(TreeNode.of("[236,104,null,null,227]")) === 9)
  }

}
