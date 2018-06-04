package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class BinaryTreePathsTest extends MoTestSuite[BinaryTreePaths] {

  g() { solution =>
    assert(solution.binaryTreePaths(TreeNode.of("[1,2,3,null,5]")) === List("1->2->5", "1->3"))
  }
}
