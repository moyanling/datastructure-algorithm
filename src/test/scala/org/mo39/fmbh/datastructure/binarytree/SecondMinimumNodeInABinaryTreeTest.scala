package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class SecondMinimumNodeInABinaryTreeTest extends MoTestSuite[SecondMinimumNodeInABinaryTree] {
  g("[2,2,2]") { solution =>
    assert(solution.findSecondMinimumValue(TreeNode.of("[2,2,2]")) === -1)
  }

  g("[2,2,5,null,null,7,5]") { solution =>
    assert(solution.findSecondMinimumValue(TreeNode.of("[2,2,5,null,null,7,5]")) === 5)
  }

  g("[1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]") { solution =>
    assert(solution.findSecondMinimumValue(TreeNode.of("[1,1,3,1,1,3,4,3,1,1,1,3,8,4,8,3,3,1,6,2,1]")) === 2)
  }
}
