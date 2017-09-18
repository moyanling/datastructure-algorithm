package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.classes.TreeNode

object InvertBinaryTree {

  sealed trait InvertBinaryTree {
    def invertTree(root: TreeNode): TreeNode
  }

  case object SOLUTION extends InvertBinaryTree {
    override def invertTree(root: TreeNode): TreeNode = {
      if (root == null) return root
      val tmp = root.left
      root.left = invertTree(root.right)
      root.right = invertTree(tmp)
      root
    }
  }

}
