package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  *
  * Given two non-empty binary trees s and t, check whether tree t has
  * exactly the same structure and node values with a subtree of s. A
  * subtree of s is a tree consists of a node in s and all of this node's
  * descendants. The tree s could also be considered as a subtree of
  * itself.
  *
  *
  * Example 1:
  *
  * Given tree s:
  *
  *      3
  *     / \
  *    4   5
  *   / \
  *  1   2
  *
  * Given tree t:
  *
  *    4
  *   / \
  *  1   2
  *
  * Return true, because t has the same structure and node values with a
  * subtree of s.
  *
  *
  * Example 2:
  *
  * Given tree s:
  *
  *      3
  *     / \
  *    4   5
  *   / \
  *  1   2
  *     /
  *    0
  *
  * Given tree t:
  *
  *    4
  *   / \
  *  1   2
  *
  * Return false.
  * }}}
  *
  * @see [[https://leetcode.com/problems/subtree-of-another-tree/ SubtreeOfAnotherTree]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SubtreeOfAnotherTree {
  def isSubtree(s: TreeNode, t: TreeNode): Boolean
}

object SubtreeOfAnotherTree extends Enumerable[SubtreeOfAnotherTree] {

  /**
    * A few tricks in this solution.
    * 1. Null node has to be presented in the String.
    * 2. To prevent Tree [1] matches Tree [12], a comma has to be appended to the end of the value.
    */
  case object Solution0 extends SubtreeOfAnotherTree {
    override def isSubtree(s: TreeNode, t: TreeNode): Boolean = {
      def postorder(node: TreeNode): String =
        node match {
          case null => "#,"
          case _    => postorder(node.left) + postorder(node.right) + node.value + ","
        }
      postorder(s).contains(postorder(t))
    }
  }

  case object Solution1 extends SubtreeOfAnotherTree {
    override def isSubtree(s: TreeNode, t: TreeNode): Boolean = {
      def sameTree(s: TreeNode, t: TreeNode): Boolean =
        (s, t) match {
          case (null, _) => t == null
          case (_, null) => false
          case _         => s.value == t.value && sameTree(s.left, t.left) && sameTree(s.right, t.right)
        }
      sameTree(s, t) || s != null && (isSubtree(s.left, t) || isSubtree(s.right, t))
    }
  }

}
