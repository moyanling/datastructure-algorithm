package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class BinaryTreeLevelOrderTraversalIITest extends MoTestSuite[BinaryTreeLevelOrderTraversalII] {

  g() { solution =>
    assert(
      solution.levelOrderBottom(TreeNode.of("[3,9,20,null,null,15,7]")) === List(List(15, 7), List(9, 20), List(3)))
  }
}
