package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable

/**
  * {{{
  * Given a binary tree, return the tilt of the whole tree.
  *
  * The tilt of a tree node is defined as the absolute difference between
  * the sum of all left subtree node values and the sum of all right
  * subtree node values. Null node has tilt 0.
  *
  * The tilt of the whole tree is defined as the sum of all nodes' tilt.
  *
  * Example:
  *
  * Input:
  *          1
  *        /   \
  *       2     3
  * Output: 1
  * Explanation:
  * Tilt of node 2 : 0
  * Tilt of node 3 : 0
  * Tilt of node 1 : |2-3| = 1
  * Tilt of binary tree : 0 + 0 + 1 = 1
  *
  *
  *
  * Note:
  *
  * The sum of node values in any subtree won't exceed the range of 32-bit
  * integer.
  * All the tilt values won't exceed the range of 32-bit integer.
  * }}}
  *
  * @see [[https://leetcode.com/problems/binary-tree-tilt/ BinaryTreeTilt]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait BinaryTreeTilt {
  def findTilt(root: TreeNode): Int
}

object BinaryTreeTilt extends Enumerable[BinaryTreeTilt] {
  case object Solution0 extends BinaryTreeTilt {
    override def findTilt(root: TreeNode): Int = {
      /* The first return value is the sum of the tilt, the second one is sum */
      def postOrder(root: TreeNode): (Int, Int) =
        root match {
          case null => (0, 0)
          case _ =>
            val (left, right) = (postOrder(root.left), postOrder(root.right))
            val tilt          = left._1 + right._1 + math.abs(left._2 - right._2)
            (tilt, left._2 + right._2 + root.value)
        }
      postOrder(root)._1
    }
  }

  /**
    * Moving the sum out helps the code cleaner with one return value.
    */
  case object Solution1 extends BinaryTreeTilt {
    override def findTilt(root: TreeNode): Int = {
      var sum = 0
      def postOrder(node: TreeNode): Int =
        node match {
          case null => 0
          case _ =>
            val (left, right) = (postOrder(node.left), postOrder(node.right))
            sum += math.abs(left - right)
            node.value + left + right
        }
      postOrder(root)
      sum
    }
  }

  case object Solution2 extends BinaryTreeTilt {
    override def findTilt(root: TreeNode): Int = {
      var (stack, tilt) = (List((1, root)), 0)
      val map           = mutable.Map[TreeNode, Int](null.asInstanceOf[TreeNode] -> 0)
      while (stack.nonEmpty) {
        val (flag, cur) = stack.head
        stack = stack.tail
        if (cur != null) {
          flag match {
            case 1 =>
              stack = List((1, cur.left), (1, cur.right), (0, cur)) ::: stack
              println(stack.map(i => if (i._2 == null) (i._1, null) else (i._1, i._2.value)))
            case 0 =>
              println(cur.value)
              tilt += math.abs(map(cur.left) - map(cur.right))
              map += cur -> (cur.value + map(cur.left) + map(cur.right))
          }
        }
      }
      tilt
    }
  }

}
