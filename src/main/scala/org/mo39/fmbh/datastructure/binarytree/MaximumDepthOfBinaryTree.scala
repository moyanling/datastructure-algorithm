package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.classes.TreeNode

object MaximumDepthOfBinaryTree {

  sealed trait MaximumDepthOfBinaryTree {
    def maxDepth(root: TreeNode): Int
  }

  case object SOLUTION extends MaximumDepthOfBinaryTree {
    override def maxDepth(root: TreeNode): Int = {
      if (root == null) 0 else math.max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
  }

}


