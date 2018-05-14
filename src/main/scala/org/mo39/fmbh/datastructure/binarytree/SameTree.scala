package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given two binary trees, write a function to check if they are the same
  * or not.
  *
  * Two binary trees are considered the same if they are structurally
  * identical and the nodes have the same value.
  *
  * Example 1:
  *
  *
  * Input:     1         1
  *           / \       / \
  *          2   3     2   3
  *
  *         [1,2,3],   [1,2,3]
  *
  * Output: true
  *
  *
  * Example 2:
  *
  *
  * Input:     1         1
  *           /           \
  *          2             2
  *
  *         [1,2],     [1,null,2]
  *
  * Output: false
  *
  *
  * Example 3:
  *
  *
  * Input:     1         1
  *           / \       / \
  *          2   1     1   2
  *
  *         [1,2,1],   [1,1,2]
  *
  * Output: false
  * }}}
  *
  * @see [[https://leetcode.com/problems/same-tree/ SameTree]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SameTree {
  def isSameTree(p: TreeNode, q: TreeNode): Boolean
}

object SameTree extends Enumerable[SameTree] {
  case object Solution extends SameTree {
    override def isSameTree(p: TreeNode, q: TreeNode): Boolean =
      if (p == null) q == null
      else if (q == null) p == null
      else {
        p.value == q.value &&
        isSameTree(p.left, q.left) &&
        isSameTree(p.right, q.right)
      }
  }
}
