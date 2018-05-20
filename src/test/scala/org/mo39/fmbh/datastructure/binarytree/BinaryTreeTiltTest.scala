package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class BinaryTreeTiltTest extends MoTestSuite[BinaryTreeTilt] {

  g() { solution =>
    assert(solution.findTilt(TreeNode.of("[1,2,3]")) === 1)
  }

}
