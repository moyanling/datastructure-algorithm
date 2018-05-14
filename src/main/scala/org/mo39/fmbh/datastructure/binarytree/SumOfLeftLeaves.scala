package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Find the sum of all left leaves in a given binary tree.
  *
  * Example:
  *
  *     3
  *    / \
  *   9  20
  *     /  \
  *    15   7
  *
  * There are two left leaves in the binary tree, with values 9 and 15
  * respectively. Return 24.
  * }}}
  *
  * @see [[https://leetcode.com/problems/sum-of-left-leaves/ SumOfLeftLeaves]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SumOfLeftLeaves {
  def sumOfLeftLeaves(root: TreeNode): Int
}

case object SumOfLeftLeaves extends Enumerable[SumOfLeftLeaves] {

  case object Solution extends SumOfLeftLeaves {
    override def sumOfLeftLeaves(root: TreeNode): Int = {
      if (root == null) return 0
      (if (root.left != null
           && root.left.left == null
           && root.left.right == null) root.left.value
       else 0) + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right)
    }

  }

}
