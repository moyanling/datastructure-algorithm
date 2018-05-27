package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class ConvertSortedArrayToBinarySearchTreeTest extends MoTestSuite[ConvertSortedArrayToBinarySearchTree] {

  g("Solution0: -10, -3, 0, 5, 9") { solution =>
    assert(solution.sortedArrayToBST(Array(-10, -3, 0, 5, 9)) === TreeNode.of("[0,-3,9,-10,null,5]"))
  }

}
