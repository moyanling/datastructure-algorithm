package org.mo39.fmbh.commons.classes

import org.mo39.fmbh.datastructure.binarytree.SameTree
import org.mo39.fmbh.datastructure.binarytree.SerializeAndDeserializeBinaryTree._

/**
  * Definition for a binary TreeNode
  */
case class TreeNode(private var _value: Int) {
  var value: Int      = _value
  var left: TreeNode  = _
  var right: TreeNode = _

  /* The String presentation of the tree CAN NOT be used to deserialize back to itself */
  override def toString: String = s"\n${Solution1.serialize(this)}\n"

  override def equals(obj: scala.Any): Boolean =
    if (!obj.isInstanceOf[TreeNode]) false
    else SameTree.Solution.isSameTree(this, obj.asInstanceOf[TreeNode])

}

object TreeNode {
  def of(s: String): TreeNode = Solution2.deserialize(s)
}
