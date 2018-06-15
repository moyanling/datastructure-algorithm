package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class BalancedBinaryTreeTest extends MoTestSuite[BalancedBinaryTree] {

  g("[3,9,20,null,null,15,7]") { solution =>
    assert(solution.isBalanced(TreeNode.of("[3,9,20,null,null,15,7]")) === true)
  }

  g("[1,2,2,3,3,null,null,4,4]") { solution =>
    assert(solution.isBalanced(TreeNode.of("[1,2,2,3,3,null,null,4,4]")) === false)
  }

}
