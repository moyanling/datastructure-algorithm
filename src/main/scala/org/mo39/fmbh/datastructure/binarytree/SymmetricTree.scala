package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.{ ProblemSource, TLE }
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a binary tree, check whether it is a mirror of itself (ie,
  * symmetric around its center).
  *
  *
  * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
  *
  *     1
  *    / \
  *   2   2
  *  / \ / \
  * 3  4 4  3
  *
  *
  *
  * But the following [1,2,2,null,3,null,3]  is not:
  *
  *     1
  *    / \
  *   2   2
  *    \   \
  *    3    3
  *
  *
  *
  *
  * Note:
  * Bonus points if you could solve it both recursively and iteratively.
  * }}}
  *
  * @see [[https://leetcode.com/problems/symmetric-tree/ SymmetricTree]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SymmetricTree {
  def isSymmetric(root: TreeNode): Boolean
}

object SymmetricTree extends Enumerable[SymmetricTree] {

  @TLE
  case object Solution0 extends SymmetricTree {
    override def isSymmetric(root: TreeNode): Boolean = {
      var level = List(root)
      while (level.nonEmpty && level.exists(_ != null)) {
        level = level.flatMap(n => if (n != null) List(n.left, n.right) else List(null, null))
        val (left, right) = level.map(n => if (n != null) n.value.toString else "#").splitAt(level.length / 2)
        if (left != right.reverse) return false
      }
      true
    }
  }

  case object Solution1 extends SymmetricTree {
    override def isSymmetric(root: TreeNode): Boolean = {
      var depth = 1
      var level = List((root, 1))
      while (level.nonEmpty) {
        depth *= 2
        level = level
          .flatMap(n => if (n._1 != null) List((n._1.left, n._2 * 2 - 1), (n._1.right, n._2 * 2)) else Nil)
          .filter(_._1 != null)
        val len = level.length
        if (level.length % 2 != 0 || (0 until len / 2).exists(i => {
              val (l, r) = (level(i), level(len - 1 - i))
              l._1.value != r._1.value || l._2 + r._2 != depth + 1
            })) return false
      }
      true
    }
  }

  /**
    * Solution2 uses a much elegant way to arrange index comparing to Solution1
    */
  case object Solution2 extends SymmetricTree {
    override def isSymmetric(root: TreeNode): Boolean = {
      if (root == null) return true
      var stack = List(root.left, root.right)
      while (stack.nonEmpty) {
        val List(l, r) = stack.take(2)
        stack = stack.tail.tail
        (l, r) match {
          case (null, null)                                      =>
          case _ if l == null || r == null || l.value != r.value => return false
          case _                                                 => stack = List(l.left, r.right, l.right, r.left) ::: stack
        }
      }
      true
    }
  }

  case object Solution3 extends SymmetricTree {
    override def isSymmetric(root: TreeNode): Boolean = {
      def isSymmetric(s: TreeNode, t: TreeNode): Boolean =
        (s, t) match {
          case (null, _) => t == null
          case (_, null) => false
          case _         => s.value == t.value && isSymmetric(s.right, t.left) && isSymmetric(s.left, t.right)
        }
      root == null || isSymmetric(root.left, root.right)
    }

  }

}
