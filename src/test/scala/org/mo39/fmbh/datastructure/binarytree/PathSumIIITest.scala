package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class PathSumIIITest extends MoTestSuite[PathSumIII] {

  g("[10,5,-3,3,2,null,11,3,-2,null,1], 8") { solution =>
    assert(solution.pathSum(TreeNode.of("[10,5,-3,3,2,null,11,3,-2,null,1]"), 8) === 3)
  }

  g("[5,4,8,11,null,13,4,7,2,null,null,5,1], 22") { solution =>
    assert(solution.pathSum(TreeNode.of("[5,4,8,11,null,13,4,7,2,null,null,5,1]"), 22) === 3)
  }

}
