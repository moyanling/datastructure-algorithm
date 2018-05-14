package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class SerializeAndDeserializeBinaryTreeTest extends MoTestSuite[SerializeAndDeserializeBinaryTree] {

  val tree1 = {
    val root = TreeNode(0)
    root.left = TreeNode(1)
    root.right = TreeNode(2)
    root.left.left = TreeNode(3)
    root.left.right = TreeNode(4)
    root.right.left = TreeNode(5)
    root.right.right = TreeNode(6)
    root
  }

  val tree2 = {
    val root = TreeNode(0)
    root.right = TreeNode(3)
    root.right.right = TreeNode(6)
    root.right.right.right = TreeNode(14)
    root
  }

  val tree3 = null

  val tree4 = {
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left.left = TreeNode(4)
    root.left.right = TreeNode(5)
    root
  }

  g() { solution =>
    assert(solution.deserialize(solution.serialize(tree1)) === tree1)
    assert(solution.deserialize(solution.serialize(tree2)) === tree2)
    assert(solution.deserialize(solution.serialize(tree3)) === tree3)
    assert(solution.deserialize(solution.serialize(tree1)) !== tree2)
  }

  test("[1, 2, 3, 4, 5]") {
    assert(SerializeAndDeserializeBinaryTree.Solution0.deserialize("[1, 2, 3, 4, 5]") === tree4)
  }

}
