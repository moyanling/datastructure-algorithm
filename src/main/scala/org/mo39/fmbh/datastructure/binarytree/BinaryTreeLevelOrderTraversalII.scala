package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * {{{
  * Given a binary tree, return the bottom-up level order traversal of its
  * nodes' values. (ie, from left to right, level by level from leaf to
  * root).
  *
  *
  * For example:
  * Given binary tree [3,9,20,null,null,15,7],
  *
  *     3
  *    / \
  *   9  20
  *     /  \
  *    15   7
  *
  *
  *
  * return its bottom-up level order traversal as:
  *
  * [
  *   [15,7],
  *   [9,20],
  *   [3]
  * ]
  * }}}
  *
  * @see [[https://leetcode.com/problems/binary-tree-level-order-traversal-ii/ BinaryTreeLevelOrderTraversalII]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait BinaryTreeLevelOrderTraversalII {
  def levelOrderBottom(root: TreeNode): List[List[Int]]
}

object BinaryTreeLevelOrderTraversalII extends Enumerable[BinaryTreeLevelOrderTraversalII] {
  case object Solution extends BinaryTreeLevelOrderTraversalII {
    override def levelOrderBottom(root: TreeNode): List[List[Int]] = {
      if (root == null) return Nil
      var (level, result) = (List(root), List[List[Int]]())
      while (level.nonEmpty) {
        result = level.map(_.value) :: result
        level = level.flatMap(n => List(n.left, n.right)).filter(_ != null)
      }
      result
    }
  }
}
