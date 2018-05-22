package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  *
  * Given a binary tree, you need to compute the length of the diameter of
  * the tree. The diameter of a binary tree is the length of the longest
  * path between any two nodes in a tree. This path may or may not pass
  * through the root.
  *
  *
  *
  * Example:
  * Given a binary tree
  *
  *           1
  *          / \
  *         2   3
  *        / \
  *       4   5
  *
  *
  *
  * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
  *
  *
  * Note:
  * The length of path between two nodes is represented by the number of
  * edges between them.
  * }}}
  *
  * @see [[https://leetcode.com/problems/diameter-of-binary-tree/ DiameterOfBinaryTree]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait DiameterOfBinaryTree {
  def diameterOfBinaryTree(root: TreeNode): Int
}

object DiameterOfBinaryTree extends Enumerable[DiameterOfBinaryTree] {
  case object Solution extends DiameterOfBinaryTree {
    override def diameterOfBinaryTree(root: TreeNode): Int = {
      var max = 0
      def postorder(node: TreeNode): Int =
        node match {
          case null => 0
          case _ =>
            val (left, right) = (postorder(node.left), postorder(node.right))
            max = math.max(max, left + right + 1)
            math.max(left, right) + 1
        }
      postorder(root)
      math.max(max - 1, 0)
    }
  }
}
