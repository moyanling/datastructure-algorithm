package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.{ Box, Enumerable }

/**
  * {{{
  * Given a Binary Search Tree (BST), convert it to a Greater Tree such
  * that every key of the original BST is changed to the original key plus
  * sum of all keys greater than the original key in BST.
  *
  *
  * Example:
  *
  * Input: The root of a Binary Search Tree like this:
  *               5
  *             /   \
  *            2     13
  *
  * Output: The root of a Greater Tree like this:
  *              18
  *             /   \
  *           20     13
  * }}}
  *
  * @see [[https://leetcode.com/problems/convert-bst-to-greater-tree/ ConvertBstToGreaterTree]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait ConvertBstToGreaterTree {
  def convertBST(root: TreeNode): TreeNode
}

object ConvertBstToGreaterTree extends Enumerable[ConvertBstToGreaterTree] {
  case object Solution0 extends ConvertBstToGreaterTree {
    override def convertBST(root: TreeNode): TreeNode = {
      def dfs(root: TreeNode): List[TreeNode] =
        root match {
          case null => Nil
          case _    => dfs(root.right) ::: (root :: dfs(root.left))
        }
      var pre = 0
      for (node <- dfs(root)) { node.value += pre; pre = node.value }
      root
    }
  }

  case object Solution1 extends ConvertBstToGreaterTree {
    override def convertBST(root: TreeNode): TreeNode = {
      def dfs(node: TreeNode, pre: Box[Int]): Unit =
        if (node != null) {
          dfs(node.right, pre)
          node.value += pre.get
          dfs(node.left, pre(node.value))
        }
      dfs(root, Box(0))
      root
    }
  }

  case object Solution2 extends ConvertBstToGreaterTree {
    override def convertBST(root: TreeNode): TreeNode = {
      var (cur, pre, stack) = (root, 0, List[TreeNode]())
      while (cur != null || stack.nonEmpty) {
        while (cur != null) {
          stack = cur :: stack
          cur = cur.right
        }
        cur = stack.head
        stack = stack.tail
        cur.value += pre
        pre = cur.value
        cur = cur.left
      }
      root
    }
  }

}
