package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a binary tree, determine if it is height-balanced.
  *
  * For this problem, a height-balanced binary tree is defined as:
  *
  *
  * a binary tree in which the depth of the two subtrees of every node
  * never differ by more than 1.
  *
  *
  * Example 1:
  *
  * Given the following tree [3,9,20,null,null,15,7]:
  *
  *
  *     3
  *    / \
  *   9  20
  *     /  \
  *    15   7
  *
  * Return true.
  *
  * Example 2:
  *
  * Given the following tree [1,2,2,3,3,null,null,4,4]:
  *
  *
  *        1
  *       / \
  *      2   2
  *     / \
  *    3   3
  *   / \
  *  4   4
  *
  *
  * Return false.
  * }}}
  *
  * @see [[https://leetcode.com/problems/balanced-binary-tree/ BalancedBinaryTree]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait BalancedBinaryTree {
  def isBalanced(root: TreeNode): Boolean
}

object BalancedBinaryTree extends Enumerable[BalancedBinaryTree] {
  case object Solution0 extends BalancedBinaryTree {
    override def isBalanced(root: TreeNode): Boolean = {
      def postorder(node: TreeNode): (Int, Boolean) =
        node match {
          case null => (0, true)
          case _ =>
            val (lDepth, lBool) = postorder(node.left)
            val (rDepth, rBool) = postorder(node.right)
            (math.max(lDepth, rDepth) + 1, lBool && rBool && math.abs(lDepth - rDepth) < 2)
        }
      postorder(root)._2
    }
  }
}
