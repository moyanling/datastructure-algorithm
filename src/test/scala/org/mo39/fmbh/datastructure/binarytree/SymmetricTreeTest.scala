package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class SymmetricTreeTest extends MoTestSuite[SymmetricTree] {

  g("[1,2,2,3,4,4,3]") { solution =>
    assert(solution.isSymmetric(TreeNode.of("[1,2,2,3,4,4,3]")) === true)
  }

  g("[1,2,2,null,3,null,3]") { solution =>
    assert(solution.isSymmetric(TreeNode.of("[1,2,2,null,3,null,3]")) === false)
  }

}
