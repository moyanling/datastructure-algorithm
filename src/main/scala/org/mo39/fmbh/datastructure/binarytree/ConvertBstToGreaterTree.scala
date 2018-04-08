package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.classes.TreeNode

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


object ConvertBstToGreaterTree {
  def convertBST(root: TreeNode): TreeNode = {
    val list = ListBuffer[TreeNode]()
    var pre = 0
    dfs(root, list)
    list.foreach(node => {
      node.value += pre
      pre = node.value
    })
    root
  }

  def dfs(root: TreeNode, list: ListBuffer[TreeNode]): Unit = {
    if (root == null) return
    dfs(root.right, list)
    list += root
    dfs(root.left, list)
  }

  def main(args: Array[String]): Unit = {
    val root = TreeNode(5)
    root.right = TreeNode(13)
    root.left = TreeNode(2)
    convertBST(root)
    println(root.value)
    println(root.right.value)
    println(root.left.value)
  }

}