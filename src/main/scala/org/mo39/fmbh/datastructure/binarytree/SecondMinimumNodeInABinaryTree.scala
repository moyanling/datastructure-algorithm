package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  *
  * Given a non-empty special binary tree consisting of nodes with the
  * non-negative value, where each node in this tree has exactly two or
  * zero sub-node. If the node has two sub-nodes, then this node's value is
  * the smaller value among its two sub-nodes.
  *
  *
  *
  * Given such a binary tree, you need to output the second minimum value
  * in the set made of all the nodes' value in the whole tree.
  *
  *
  *
  * If no such second minimum value exists, output -1 instead.
  *
  *
  * Example 1:
  *
  * Input:
  *     2
  *    / \
  *   2   5
  *      / \
  *     5   7
  *
  * Output: 5
  * Explanation: The smallest value is 2, the second smallest value is 5.
  *
  *
  *
  * Example 2:
  *
  * Input:
  *     2
  *    / \
  *   2   2
  *
  * Output: -1
  * Explanation: The smallest value is 2, but there isn't any second
  * smallest value.
  * }}}
  *
  * @see [[https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/ SecondMinimumNodeInABinaryTree]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SecondMinimumNodeInABinaryTree {
  def findSecondMinimumValue(root: TreeNode): Int
}

object SecondMinimumNodeInABinaryTree extends Enumerable[SecondMinimumNodeInABinaryTree] {
  case object Solution0 extends SecondMinimumNodeInABinaryTree {
    override def findSecondMinimumValue(root: TreeNode): Int = {
      if (root == null) return -1
      var (set, level) = (Set[Int](), List[TreeNode](root))
      while (level.nonEmpty) {
        val s = level.map(_.value).toSet
        set ++= s
        level = level.flatMap(n => List(n.left, n.right)).filter(_ != null)
        if (set.size > 1 && (!s.contains(root.value) || level.isEmpty)) return set.toList.sorted.apply(1)
      }
      -1
    }
  }
  case object Solution1 extends SecondMinimumNodeInABinaryTree {
    override def findSecondMinimumValue(root: TreeNode): Int = {
      def recur(node: TreeNode): Int =
        if (node == null) -1
        else if (node.value > root.value) node.value // Fast return
        else {
          val (left, right) = (recur(node.left), recur(node.right))
          if (left == -1 || right == -1) if (left == -1) right else left
          else math.min(left, right)
        }
      recur(root)
    }
  }
}
