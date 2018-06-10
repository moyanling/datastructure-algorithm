package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class SubtreeOfAnotherTreeTest extends MoTestSuite[SubtreeOfAnotherTree] {

  g("[3,4,5,1,2]") { solution =>
    assert(solution.isSubtree(TreeNode.of("[3,4,5,1,2]"), TreeNode.of("[4,1,2]")) === true)
  }

  g("[1,2,3]") { solution =>
    assert(solution.isSubtree(TreeNode.of("[1,2,3]"), TreeNode.of("[2,3]")) === false)
  }

  g("[1,null,2]") { solution =>
    assert(solution.isSubtree(TreeNode.of("[1,null,2]"), TreeNode.of("[1,2]")) === false)
  }

  g("[12]") { solution =>
    assert(solution.isSubtree(TreeNode.of("[12]"), TreeNode.of("[1]")) === false)
  }

}
