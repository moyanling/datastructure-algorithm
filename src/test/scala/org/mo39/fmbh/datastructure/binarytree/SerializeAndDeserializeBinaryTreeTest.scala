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

  val tree5 = {
    val root = TreeNode(5)
    root.left = TreeNode(4)
    root.left.left = TreeNode(3)
    root.left.left.left = TreeNode(-1)
    root.right = TreeNode(7)
    root.right.left = TreeNode(2)
    root.right.left.left = TreeNode(9)
    root
  }

  g("tree1") { solution =>
    assert(solution.deserialize(solution.serialize(tree1)) === tree1)
  }

  g("tree2") { solution =>
    assert(solution.deserialize(solution.serialize(tree2)) === tree2)
  }

  g("tree3") { solution =>
    assert(solution.deserialize(solution.serialize(tree3)) === tree3)
  }
  test("Solution0 deserialize: [1, 2, 3, 4, 5]") {
    assert(SerializeAndDeserializeBinaryTree.Solution0.deserialize("[1, 2, 3, 4, 5]") === tree4)
  }
  test("Solution2 deserialize: [5,4,7,3,null,2,null,-1,null,9]") {
    assert(SerializeAndDeserializeBinaryTree.Solution2.deserialize("[5,4,7,3,null,2,null,-1,null,9]") === tree5)
  }

}
