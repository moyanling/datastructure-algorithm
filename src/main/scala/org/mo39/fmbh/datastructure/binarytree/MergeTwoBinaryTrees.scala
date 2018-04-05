package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.classes.TreeNode

class MergeTwoBinaryTrees {

  sealed trait MergeTwoBinaryTrees {
    def mergeTrees(t1: TreeNode, t2: TreeNode): TreeNode
  }

  case object SOLUTION extends MergeTwoBinaryTrees {
    override def mergeTrees(t1: TreeNode, t2: TreeNode): TreeNode = {
      if (t1 == null) return t2
      if (t2 == null) return t1
      t1.value += t2.value
      t1.left = mergeTrees(t1.left, t2.left)
      t1.right = mergeTrees(t1.right, t2.right)
      t1
    }
  }

}
