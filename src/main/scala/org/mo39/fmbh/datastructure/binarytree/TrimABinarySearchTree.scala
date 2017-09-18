package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.classes.TreeNode

object TrimABinarySearchTree {

  sealed trait TrimABinarySearchTree {
    def trimBST(root: TreeNode, L: Int, R: Int): TreeNode
  }

  case object SOLUTION_0 extends TrimABinarySearchTree {
    override def trimBST(root: TreeNode, L: Int, R: Int): TreeNode = {
      val newRoot = getRoot(root, L, R)
      if (newRoot == null) return newRoot
      trimLeft(newRoot, L)
      trimRight(newRoot, R)
      newRoot
    }

    def getRoot(root: TreeNode, L: Int, R: Int): TreeNode = {
      if (root == null || L <= root.value && root.value <= R) return root
      if (L <= root.value) getRoot(root.left, L, R) else getRoot(root.right, L, R)
    }

    def trimLeft(root: TreeNode, L: Int): Unit = {
      var (left, pre) = (root.left, root)
      while (left != null) {
        if (left.value < L) {
          pre.left = left.right
          left = pre
        } else {
          pre = left
          left = left.left
        }
      }
    }

    def trimRight(root: TreeNode, R: Int): Unit = {
      var (right, pre) = (root.right, root)
      while (right != null) {
        if (right.value > R) {
          pre.right = right.left
          right = pre
        } else {
          pre = right
          right = right.right
        }
      }
    }
  }

  case object SOLUTION_1 extends TrimABinarySearchTree {
    override def trimBST(root: TreeNode, L: Int, R: Int): TreeNode = {
      if (root == null) return root
      if (root.value < L) return trimBST(root.right, L, R)
      if (root.value > R) return trimBST(root.left, L, R)
      root.left = trimBST(root.left, L, R)
      root.right = trimBST(root.right, L, R)
      root
    }
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(1)
    root.left = new TreeNode(0)
    root.right = new TreeNode(2)
    println(SOLUTION_0.trimBST(root, 1, 2))
  }

}
