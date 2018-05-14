package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.classes.TreeNode

object ConstructStringFromBinaryTree {

  sealed trait ConstructStringFromBinaryTree {
    def tree2str(root: TreeNode): String
  }

  case object SOLUTION_0 extends ConstructStringFromBinaryTree {
    override def tree2str(t: TreeNode): String = {
      if (t == null) return ""
      recur(t, new StringBuilder()).toString()
    }

    def recur(root: TreeNode, sb: StringBuilder): StringBuilder = {
      sb.append(root.value)
      if (root.right == null && root.left != null) {
        sb.append('(')
        recur(root.left, sb)
        sb.append(')')
      } else if (root.right != null && root.left == null) {
        sb.append("()")
        sb.append('(')
        recur(root.right, sb)
        sb.append(')')
      } else if (root.right != null && root.left != null) {
        sb.append('(')
        recur(root.left, sb)
        sb.append(')')
        sb.append('(')
        recur(root.right, sb)
        sb.append(')')
      } else sb
    }
  }

  case object SOLUTION_1 extends ConstructStringFromBinaryTree {
    override def tree2str(t: TreeNode): String = {
      if (t == null) return ""
      val s             = t.value.toString
      val (left, right) = (tree2str(t.left), tree2str(t.right))
      if (left == "" && right == "") s
      else if (left == "" && right != "") s + "()" + '(' + right + ')'
      else if (left != "" && right == "") s + '(' + left + ')'
      else s + '(' + left + ")(" + right + ')'
    }
  }

}
