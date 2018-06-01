package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a non-empty binary search tree and a target value,
  * find the value in the BST that is closest to the target.
  *
  * Note:
  *
  * Given target value is a floating point.
  * You are guaranteed to have only one unique value in the BST that is closest to the target.
  * Example:
  *
  * Input: root = [4,2,5,1,3], target = 3.714286
  *
  *     4
  *    / \
  *   2   5
  *  / \
  * 1   3
  *
  * Output: 4
  * }}}
  *
  * @see [[https://leetcode.com/problems/closest-binary-search-tree-value/ ClosestBinarySearchTreeValue]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait ClosestBinarySearchTreeValue {
  def closestValue(root: TreeNode, target: Double): Int
}

object ClosestBinarySearchTreeValue extends Enumerable[ClosestBinarySearchTreeValue] {
  case object Solution extends ClosestBinarySearchTreeValue {
    override def closestValue(root: TreeNode, target: Double): Int = {
      var cur = root
      while (cur != null) {
        println(cur.value)
        if (cur.value < target) {
          if (cur.right == null) return cur.value
          else if (cur.right.value > target) return List(cur.value, cur.right.value).minBy(i => math.abs(i - target))
          else cur = cur.right
        } else if (cur.value > target) {
          if (cur.left == null) return cur.value
          else if (cur.left.value < target) return List(cur.value, cur.left.value).minBy(i => math.abs(i - target))
          else cur = cur.left
        } else return cur.value
      }
      -1
    }
  }
}
