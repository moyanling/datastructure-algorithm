package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ListBuffer

/**
  * {{{
  * Given an array where elements are sorted in ascending order, convert it
  * to a height balanced BST.
  *
  * For this problem, a height-balanced binary tree is defined as a binary
  * tree in which the depth of the two subtrees of every node never differ
  * by more than 1.
  *
  * Example:
  *
  *
  * Given the sorted array: [-10,-3,0,5,9],
  *
  * One possible answer is: [0,-3,9,-10,null,5], which represents the
  * following height balanced BST:
  *
  *       0
  *      / \
  *    -3   9
  *    /   /
  *  -10  5
  * }}}
  *
  * @see [[https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/ ConvertSortedArrayToBinarySearchTree]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait ConvertSortedArrayToBinarySearchTree {
  def sortedArrayToBST(nums: Array[Int]): TreeNode
}

object ConvertSortedArrayToBinarySearchTree extends Enumerable[ConvertSortedArrayToBinarySearchTree] {
  case object Solution extends ConvertSortedArrayToBinarySearchTree {
    override def sortedArrayToBST(nums: Array[Int]): TreeNode =
      nums.length match {
        case 0 => null
        case 1 => TreeNode(nums(0))
        case _ =>
          val half = nums.length / 2
          val (left, root, right) =
            if (nums.length % 2 == 1) (nums.take(half), nums(half), nums.takeRight(half))
            else (nums.take(half), nums(half), nums.takeRight(half - 1))
          val rootNode = TreeNode(root)
          rootNode.left = sortedArrayToBST(left)
          rootNode.right = sortedArrayToBST(right)
          rootNode
      }
  }
}
