package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ListBuffer

/**
  * {{{
  * Given a binary tree, return the postorder traversal of its nodes'
  * values.
  *
  * Example:
  *
  *
  * Input: [1,null,2,3]
  *    1
  *     \
  *      2
  *     /
  *    3
  *
  * Output: [3,2,1]
  *
  *
  * Follow up: Recursive solution is trivial, could you do it iteratively?
  * }}}
  *
  * @see [[https://leetcode.com/problems/binary-tree-postorder-traversal/ BinaryTreePostorderTraversal]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait BinaryTreePostorderTraversal {
  def postorderTraversal(root: TreeNode): List[Int]
}

object BinaryTreePostorderTraversal extends Enumerable[BinaryTreePostorderTraversal] {

  case object Solution0 extends BinaryTreePostorderTraversal {
    override def postorderTraversal(root: TreeNode): List[Int] =
      root match {
        case null => Nil
        case _    => postorderTraversal(root.left) ::: postorderTraversal(root.right) ::: List(root.value)
      }
  }

  case object Solution1 extends BinaryTreePostorderTraversal {
    override def postorderTraversal(root: TreeNode): List[Int] = {
      if (root == null) return Nil
      var cur: TreeNode   = null
      var (stack, result) = (List[TreeNode](root), List[Int]())
      while (stack.nonEmpty) {
        cur = stack.head
        result = cur.value :: result
        stack = stack.tail
        if (cur.left != null) stack = cur.left :: stack
        if (cur.right != null) stack = cur.right :: stack
      }
      result
    }
  }

  /**
    * It's preferable that this one does not require to check root is null
    */
  case object Solution2 extends BinaryTreePostorderTraversal {
    override def postorderTraversal(root: TreeNode): List[Int] = {
      var (stack, result) = (List(root), List[Int]())
      while (stack.nonEmpty) {
        val cur = stack.head
        stack = stack.tail
        if (cur != null) {
          result = cur.value :: result
          stack = List(cur.right, cur.left) ::: stack
        }
      }
      result
    }
  }

  /**
    * This DFS uses a flag to mark visited nodes and push them to the bottom of the Stack,
    * so when poping it out of the Stack, there's no need to prepend it the the list.
    *
    * It's more like a bottom up visit comparing to above solutions where goes up to down and prepend the value.
    */
  case object Solution3 extends BinaryTreePostorderTraversal {
    override def postorderTraversal(root: TreeNode): List[Int] = {
      var (stack, result) = (List((1, root)), ListBuffer[Int]())
      while (stack.nonEmpty) {
        val (flag, cur) = stack.head
        stack = stack.tail
        if (cur != null) {
          flag match {
            case 1 => stack = List((1, cur.left), (1, cur.right), (0, cur)) ::: stack
            case 0 => result += cur.value // This line is the key difference.
          }
        }
      }
      result.toList
    }
  }

}
