package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * You are given a binary tree in which each node contains an integer
  * value.
  *
  * Find the number of paths that sum to a given value.
  *
  * The path does not need to start or end at the root or a leaf, but it
  * must go downwards
  * (traveling only from parent nodes to child nodes).
  *
  * The tree has no more than 1,000 nodes and the values are in the range
  * -1,000,000 to 1,000,000.
  *
  * Example:
  *
  * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
  *
  *       10
  *      /  \
  *     5   -3
  *    / \    \
  *   3   2   11
  *  / \   \
  * 3  -2   1
  *
  * Return 3. The paths that sum to 8 are:
  *
  * 1.  5 -> 3
  * 2.  5 -> 2 -> 1
  * 3. -3 -> 11
  * }}}
  *
  * @see [[https://leetcode.com/problems/path-sum-iii/ PathSumIII]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait PathSumIII {
  def pathSum(root: TreeNode, sum: Int): Int
}

object PathSumIII extends Enumerable[PathSumIII] {
  case object Solution0 extends PathSumIII {
    override def pathSum(root: TreeNode, sum: Int): Int = {
      var count = 0
      var stack = List((root, Map[Int, Int]()))
      while (stack.nonEmpty) {
        val (cur, map) = stack.head
        stack = stack.tail
        if (cur != null) {
          if (map.contains(cur.value - sum)) count += map(cur.value - sum)
          if (cur.value == sum) count += 1 // Don't forget this
          val m = map.updated(cur.value, map.getOrElse(cur.value, 0) + 1)
          stack = List((cur.left, m), (cur.right, m)) ::: stack
          if (cur.left != null) cur.left.value += cur.value
          if (cur.right != null) cur.right.value += cur.value
        }
      }
      count
    }
  }

  case object Solution1 extends PathSumIII {
    override def pathSum(root: TreeNode, sum: Int): Int = ???
  }

}
