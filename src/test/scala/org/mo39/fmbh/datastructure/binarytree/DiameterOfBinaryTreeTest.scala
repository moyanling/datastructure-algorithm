package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class DiameterOfBinaryTreeTest extends MoTestSuite[DiameterOfBinaryTree] {

  g("empty") {solution =>
    assert(solution.diameterOfBinaryTree(null) === 0)
  }

  g("single node") {solution =>
    assert(solution.diameterOfBinaryTree(TreeNode(0)) === 0)
  }

  g("[1,2,3,4,5]") { solution =>
    assert(solution.diameterOfBinaryTree(TreeNode.of("[1,2,3,4,5]")) === 3)
  }

  g("Complex one") { solution =>
    val root = TreeNode.of("[1,2]")
    root.right = TreeNode.of("[3,4,5,6,null,7,null,null,null,null,null,8]")
    assert(solution.diameterOfBinaryTree(root) === 5)
  }

}
