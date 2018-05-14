package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.{ Box, Enumerable }

import scala.collection.mutable.ListBuffer

/**
  * {{{
  * Given a binary search tree with non-negative values, find the minimum
  * absolute difference between values of any two nodes.
  *
  *
  * Example:
  *
  * Input:
  *
  *    1
  *     \
  *      3
  *     /
  *    2
  *
  * Output:
  * 1
  *
  * Explanation:
  * The minimum absolute difference is 1, which is the difference between 2
  * and 1 (or between 2 and 3).
  *
  *
  *
  *
  * Note:
  * There are at least two nodes in this BST.
  * }}}
  *
  * @see [[https://leetcode.com/problems/minimum-absolute-difference-in-bst/ MinimumAbsoluteDifferenceInBst]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MinimumAbsoluteDifferenceInBst {
  def getMinimumDifference(root: TreeNode): Int
}

object MinimumAbsoluteDifferenceInBst extends Enumerable[MinimumAbsoluteDifferenceInBst] {

  case object Solution0 extends MinimumAbsoluteDifferenceInBst {
    override def getMinimumDifference(root: TreeNode): Int = {
      val list = inorder(root)
      (1 until list.length).map(i => list(i) - list(i - 1)).min
    }

    def inorder(root: TreeNode): ListBuffer[Int] =
      if (root == null) ListBuffer.empty
      else inorder(root.left) ++ (root.value +: inorder(root.right))
  }

  /**
    * The result of the sub problem does not contribute to the result of the original problem,
    * so the return result is not helpful. It has to be calculated in place.
    */
  case object Solution1 extends MinimumAbsoluteDifferenceInBst {
    override def getMinimumDifference(root: TreeNode): Int = inorder(root, Box.empty, Box(Int.MaxValue)).get
    def inorder(root: TreeNode, pre: Box[Int], min: Box[Int]): Box[Int] = {
      if (root == null) return Box.empty
      inorder(root.left, pre, min)
      if (pre.isEmpty) pre(root.value)
      else min(math.min(root.value - pre.get, min.get))
      inorder(root.right, pre(root.value), min)
      min
    }
  }

  case object Solution2 extends MinimumAbsoluteDifferenceInBst {
    override def getMinimumDifference(root: TreeNode): Int = {
      var stack           = ListBuffer[TreeNode]()
      var (cur, pre, min) = (root, null.asInstanceOf[TreeNode], Int.MaxValue)
      while (cur != null || stack.nonEmpty) {
        while (cur != null) {
          cur +=: stack
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
