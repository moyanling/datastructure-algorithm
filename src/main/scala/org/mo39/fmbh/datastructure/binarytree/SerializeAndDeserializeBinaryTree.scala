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
      "[" + list.mkString(",") + "]"
    }

    override def deserialize(s: String): TreeNode = {
      require(s != null)
      if (s == "[]") return null
      SerializeAndDeserializeBinaryTree.deserialize(s, "null")
    }
  }

  private def deserialize(s: String, nullPresentation: String) = {
    val arr = s.stripPrefix("[").stripSuffix("]").split(",").map(_.trim)
    val mkNode = (i: Int) => {
      if (arr(i) == nullPresentation) null
      else TreeNode(arr(i).toInt)
    }
    val root = mkNode(0)
    var (i, level) = (0, List(root))
    while (level.nonEmpty) {
      var nextLevel = ListBuffer[TreeNode]()
      for (node <- level) {
        i += 2
        if (node != null) {
          node.left = mkNode(i - 1)
          node.right = mkNode(i)
          nextLevel ++= List(node.left, node.right)
        } else nextLevel ++= List(null, null)
      }
      level = if (i >= arr.length - 1) Nil else nextLevel.toList
    }
    root
  }

  case object Solution1 extends SerializeAndDeserializeBinaryTree {
    override def serialize(root: TreeNode): String = {
      if (root == null) return "null"
      var (buf, level) = (ArrayBuffer[String](), List(root))
      while (level.nonEmpty) {
        buf += level
          .map(n => if (n == null) "#" else n.value.toString)
          .mkString(", ")
        var next = ListBuffer[TreeNode]()
        for (node <- level) {
          if (node != null) next ++= List(node.left, node.right)
          else next ++= List(null, null)
        }
        level = if (next.forall(_ == null)) Nil else next.toList
      }
      buf.mkString("\n")
    }

    override def deserialize(s: String): TreeNode = {
      require(s != null && s.contains('\n') || s == "null")
      if (s == "null") return null
      SerializeAndDeserializeBinaryTree.deserialize(
        "[" + s.split('\n').mkString(", ") + "]",
        "#")
    }
  }
}
