package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
  * {{{
  * Serialization is the process of converting a data structure or object
  * into a sequence of bits so that it can be stored in a file or memory
  * buffer, or transmitted across a network connection link to be
  * reconstructed later in the same or another computer environment.
  *
  * Design an algorithm to serialize and deserialize a binary tree. There
  * is no restriction on how your serialization/deserialization algorithm
  * should work. You just need to ensure that a binary tree can be
  * serialized to a string and this string can be deserialized to the
  * original tree structure.
  *
  * For example, you may serialize the following tree
  *
  *
  *     1
  *    / \
  *   2   3
  *      / \
  *     4   5
  *
  *
  * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes
  * a binary tree. You do not necessarily need to follow this format, so
  * please be creative and come up with different approaches yourself.
  *
  *  
  *
  * Note: Do not use class member/global/static variables to store states.
  * Your serialize and deserialize algorithms should be stateless.
  *
  * Credits:
  * Special thanks to @Louis1992 for adding this problem and creating all
  * test cases.
  * }}}
  *
  * @see [[https://leetcode.com/problems/serialize-and-deserialize-binary-tree/ SerializeAndDeserializeBinaryTree]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SerializeAndDeserializeBinaryTree {
  def serialize(treeNode: TreeNode): String
  def deserialize(s: String): TreeNode
}

case object SerializeAndDeserializeBinaryTree
    extends Enumerable[SerializeAndDeserializeBinaryTree] {
  /* It follows the LeetCode serialize format */
  case object Solution0 extends SerializeAndDeserializeBinaryTree {
    override def serialize(treeNode: TreeNode): String = {
      if (treeNode == null) return "[]"
      var level = List[TreeNode](treeNode)
      var list = ListBuffer[String]()
      while (level.nonEmpty) {
        list ++= level.map(n => if (n != null) n.value.toString else "null")
        val nextLevel = level
          .flatMap(n =>
            if (n != null) List(n.left, n.right) else List(null, null))
        level = if (nextLevel.exists(_ != null)) nextLevel else Nil
      }
      list = list.dropRight(list.length - list.lastIndexWhere(_ != null) - 1)
      "[" + list.mkString(", ") + "]"
    }

    override def deserialize(s: String): TreeNode = {
      require(s != null)
      if (s == "[]") return null
      val arr = s.stripPrefix("[").stripSuffix("]").split(",").map(_.trim)
      val mkNode = (i: Int) => {
        if (arr(i) == "null") null else TreeNode(arr(i).toInt)
      }
      val root = mkNode(0)
      var (i, level) = (0, List(root))
      while (level.nonEmpty) {
        var nextLevel = ListBuffer[TreeNode]()
        for (node <- level) {
          i += 2
          if (node != null) node.left = mkNode(i - 1)
          if (node != null) node.right = mkNode(i)
          if (node != null) nextLevel ++= List(node.left, node.right)
          else nextLevel ++= List(null, null)
        }
        level = if (i >= arr.length - 1) Nil else nextLevel.toList
      }
      root
    }
  }

  case object Solution1 extends SerializeAndDeserializeBinaryTree {
    override def serialize(treeNode: TreeNode): String = {
      if (treeNode == null) return "null"
      var (buf, level) = (ArrayBuffer[String](), List(treeNode))
      while (level.nonEmpty) {
        buf += level
          .map(node => if (node == null) "#" else node.value.toString)
          .mkString(", ")
        level = level.flatMap(
          node =>
            if (node != null) List(node.left, node.right)
            else List(null, null))
        val set = level.to[Set]
        if (set.size == 1 && set.contains(null)) level = Nil
      }
      buf.mkString("\n")
    }

    override def deserialize(s: String): TreeNode = {
      require(s != null && s.contains('\n') || s == "null")
      if (s == "null") return null
      Solution0.deserialize("[" + s.split('\n').mkString(", ") + "]")
    }
  }

  def main(args: Array[String]): Unit = {
    val root = TreeNode(1)
    root.right = TreeNode(3)
    root.right.right = TreeNode(7)
    println(Solution0.serialize(root))
    println(Solution0.deserialize("[1, null, 3, null, null, null, 7]"))
  }

}
