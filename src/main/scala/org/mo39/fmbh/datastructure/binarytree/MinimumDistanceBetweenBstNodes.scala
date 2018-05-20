package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a Binary Search Tree (BST) with the root node root, return the
  * minimum difference between the values of any two different nodes in the
  * tree.
  *
  * Example :
  *
  *
  * Input: root = [4,2,6,1,3,null,null]
  * Output: 1
  * Explanation:
  * Note that root is a TreeNode object, not an array.
  *
  * The given tree [4,2,6,1,3,null,null] is represented by the following
  * diagram:
  *
  *           4
  *         /   \
  *       2      6
  *      / \
  *     1   3
  *
  * while the minimum difference in this tree is 1, it occurs between node
  * 1 and node 2, also between node 3 and node 2.
  *
  *
  * Note:
  *
  *
  * 	The size of the BST will be between 2 and 100.
  * 	The BST is always valid, each node's value is an integer, and each
  * node's value is different.
  * }}}
  *
  * @see [[https://leetcode.com/problems/minimum-distance-between-bst-nodes/ MinimumDistanceBetweenBstNodes]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MinimumDistanceBetweenBstNodes {
  def minDiffInBST(root: TreeNode): Int
}

object MinimumDistanceBetweenBstNodes extends Enumerable[MinimumAbsoluteDifferenceInBst] {

  case object Solution0 extends MinimumDistanceBetweenBstNodes {
    override def minDiffInBST(root: TreeNode): Int = {
      val list = inorder(root)
      (1 until list.length).map(i => list(i).value - list(i - 1).value).min
    }

    def inorder(node: TreeNode): List[TreeNode] = {
      if (node == null) return Nil
      inorder(node.left) ::: (node +: inorder(node.right))
    }
  }

  case object Solution1 extends MinimumDistanceBetweenBstNodes {
    override def minDiffInBST(root: TreeNode): Int = {
      var (cur, pre, min, stack) = (root, null.asInstanceOf[TreeNode], Int.MaxValue, List[TreeNode]())
      while (cur != null || stack.nonEmpty) {
        while (cur != null) {
          stack = cur :: stack
          cur = cur.left
        }
        cur = stack.head
        if (pre != null) min = math.min(min, cur.value - pre.value)
        pre = cur
        stack = stack.tail
        cur = cur.right
      }
      min
    }
  }

}
