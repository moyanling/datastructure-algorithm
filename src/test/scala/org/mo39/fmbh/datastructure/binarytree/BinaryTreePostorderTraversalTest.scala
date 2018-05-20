package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class BinaryTreePostorderTraversalTest extends MoTestSuite[BinaryTreePostorderTraversal] {

  g("null") { solution =>
    assert(solution.postorderTraversal(null) === Nil)
  }

  g("[1,null,2,null,null,3]") { solution =>
    assert(solution.postorderTraversal(TreeNode.of("[1,null,2,null,null,3]")) === List(3, 2, 1))
  }

}
