package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable

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
  case object Solution0 extends DiameterOfBinaryTree {
    override def diameterOfBinaryTree(root: TreeNode): Int = {
      var max = 0
      def postorder(node: TreeNode): Int =
        node match {
          case null => 0
          case _ =>
            val (left, right) = (postorder(node.left), postorder(node.right))
            max = math.max(max, left + right)
            math.max(left, right) + 1
        }
      postorder(root)
      max
    }
  }

  case object Solution1 extends DiameterOfBinaryTree {
    override def diameterOfBinaryTree(root: TreeNode): Int = {
      def postorder(node: TreeNode): (Int, Int) =
        node match {
          case null => (0, 0)
          case _ =>
            val (lm, rm) = (postorder(node.left), postorder(node.right))
            (Array(lm._1, rm._1, lm._2 + rm._2).max, math.max(lm._2, rm._2) + 1)
        }
      postorder(root)._1
    }
  }

  case object Solution2 extends DiameterOfBinaryTree {
    override def diameterOfBinaryTree(root: TreeNode): Int = {
      val map          = mutable.Map(null.asInstanceOf[TreeNode] -> 0)
      var (stack, max) = (List((1, root)), 0)
      while (stack.nonEmpty) {
        val (flag, cur) = stack.head
        stack = stack.tail
        if (cur != null) {
          flag match {
            case 1 => stack = List((1, cur.left), (1, cur.right), (0, cur)) ::: stack
            case 0 =>
              map.update(cur, List(map(cur.left), map(cur.right)).max + 1)
              max = List(max, map(cur.left) + map(cur.right)).max
          }
        }
      }
      max
    }
  }

}
