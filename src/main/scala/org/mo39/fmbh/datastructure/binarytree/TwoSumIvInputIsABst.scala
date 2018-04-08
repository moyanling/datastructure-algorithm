package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.classes.TreeNode

import scala.collection.mutable

/** The BST structure does not bring any advantage in Time Complexity */
object TwoSumIvInputIsABst {

  /** This can be applied to BinaryTree not only BST. */
  def findTarget(root: TreeNode, k: Int): Boolean = {
    if (root == null) return false
    val set = mutable.Set[Int]()
    val stack = mutable.Stack[TreeNode]()
    stack.push(root)
    while (stack.nonEmpty) {
      val cur = stack.pop
      if (set.contains(k - cur.value)) return true
      set += cur.value
      if (cur.right != null) stack.push(cur.right)
      if (cur.left != null) stack.push(cur.left)
    }
    false
  }


}
