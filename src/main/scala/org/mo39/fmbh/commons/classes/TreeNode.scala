package org.mo39.fmbh.commons.classes

import org.mo39.fmbh.datastructure.binarytree.SerializeAndDeserializeBinaryTree

/**
  * Definition for a binary TreeNode
  */
case class TreeNode(private var _value: Int) {
  var value: Int = _value
  var left: TreeNode = _
  var right: TreeNode = _

  override def toString: String =
    SerializeAndDeserializeBinaryTree.Solution1.serialize(this)

}
