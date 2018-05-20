package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class ConvertBstToGreaterTreeTest extends MoTestSuite[ConvertBstToGreaterTree] {

  g("[5,2,13]") { solution =>
    assert(solution.convertBST(TreeNode.of("[5,2,13]")) === TreeNode.of("[18,20,13]"))
  }

  g("[1,0,4,-2,null,3]") { solution =>
    assert(solution.convertBST(TreeNode.of("[1,0,4,-2,null,3]")) === TreeNode.of("[8,8,4,6,null,7]"))
  }

}
