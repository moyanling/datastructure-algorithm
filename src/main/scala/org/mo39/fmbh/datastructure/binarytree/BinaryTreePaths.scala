package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a binary tree, return all root-to-leaf paths.
  *
  * Note: A leaf is a node with no children.
  *
  * Example:
  *
  *
  * Input:
  *
  *    1
  *  /   \
  * 2     3
  *  \
  *   5
  *
  * Output: ["1->2->5", "1->3"]
  *
  * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
  * }}}
  *
  * @see [[https://leetcode.com/problems/binary-tree-paths/ BinaryTreePaths]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait BinaryTreePaths {
  def binaryTreePaths(root: TreeNode): List[String]
}

object BinaryTreePaths extends Enumerable[BinaryTreePaths] {
  case object Solution0 extends BinaryTreePaths {
    override def binaryTreePaths(root: TreeNode): List[String] =
      root match {
        case null => Nil
        case _ =>
          val f             = (l: List[String]) => l.map(i => s"${root.value}->$i")
          val (left, right) = (binaryTreePaths(root.left), binaryTreePaths(root.right))
          if (left.isEmpty && right.isEmpty) List(root.value.toString)
          else f(left) ::: f(right)
      }
  }
  case object Solution1 extends BinaryTreePaths {
    override def binaryTreePaths(root: TreeNode): List[String] = ???
  }
}
