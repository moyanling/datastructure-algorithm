package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.{ ArrayBuffer, ListBuffer }

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

case object SerializeAndDeserializeBinaryTree extends Enumerable[SerializeAndDeserializeBinaryTree] {

  private def getChildren(node: TreeNode) = if (node == null) List(null, null) else List(node.left, node.right)

  private def deserialize(s: String, nullPresentation: String) = {
    val arr        = s.stripPrefix("[").stripSuffix("]").split(",").map(_.trim)
    val mkNode     = (i: Int) => if (i >= arr.length || arr(i) == nullPresentation) null else TreeNode(arr(i).toInt)
    val root       = mkNode(0)
    var (i, level) = (0, List(root))
    while (level.nonEmpty && i < arr.length) {
      for (node <- level) {
        i += 2
        if (node != null) {
          node.left = mkNode(i - 1)
          node.right = mkNode(i)
        }
      }
      level = level.flatMap(getChildren)
    }
    root
  }

  case object Solution0 extends SerializeAndDeserializeBinaryTree {
    override def serialize(treeNode: TreeNode): String = {
      if (treeNode == null) return "[]"
      var level = List[TreeNode](treeNode)
      var list  = ListBuffer[String]()
      while (level.nonEmpty) {
        list ++= level.map(n => if (n != null) n.value.toString else "null")
        val nextLevel = level.flatMap(getChildren)
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

  case object Solution1 extends SerializeAndDeserializeBinaryTree {
    override def serialize(root: TreeNode): String = {
      if (root == null) return "null"
      var (buf, level) = (ArrayBuffer[String](), List(root))
      while (level.nonEmpty && level.exists(_ != null)) {
        buf += level.map(n => if (n == null) "#" else n.value.toString).mkString(", ")
        level = level.flatMap(getChildren)
      }
      buf.mkString("\n")
    }

    override def deserialize(s: String): TreeNode = {
      require(s != null && s.contains('\n') || s == "null")
      if (s == "null") return null
      SerializeAndDeserializeBinaryTree.deserialize(s.split('\n').mkString(","), "#")
    }
  }

  /* This solution follows the LeetCode serialize format */
  case object Solution2 extends SerializeAndDeserializeBinaryTree {
    override def serialize(root: TreeNode): String = {
      var result = ArrayBuffer[String]()
      var level  = List(root)
      while (level.nonEmpty && level.exists(_ != null)) {
        result += level.map(n => if (n == null) "null" else n.value).mkString(",")
        level = level.filter(_ != null).flatMap(n => List(n.left, n.right))
      }
      result.mkString("[", ",", "]")
    }

    override def deserialize(s: String): TreeNode = {
      if (s == "[]") return null
      val arr        = s.stripPrefix("[").stripSuffix("]").split(",").map(_.trim)
      val mkNode     = (i: Int) => if (i >= arr.length || arr(i) == "null") null else TreeNode(arr(i).toInt)
      val root       = mkNode(0)
      var (i, level) = (1, List(root))
      while (level.nonEmpty && i < arr.length) {
        for (node <- level if node != null) {
          node.left = mkNode(i)
          node.right = mkNode(i + 1)
          i += 2
        }
        level = level.filter(_ != null).flatMap(n => List(n.left, n.right))
      }
      root
    }
  }

}
