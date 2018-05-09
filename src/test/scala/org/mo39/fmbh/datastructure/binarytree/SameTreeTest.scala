package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.TreeNode

class SameTreeTest extends MoTestSuite[SameTree] {

  val tree1 = {
    val root = TreeNode(0)
    root.left = TreeNode(1)
    root.right = TreeNode(2)
    root
  }

  val tree2 = {
    val root = TreeNode(0)
    root.left = TreeNode(1)
    root.right = TreeNode(2)
    root
  }

  val tree3 = {
    val root = TreeNode(0)
    root.right = TreeNode(3)
    root.right.right = TreeNode(6)
    root.right.right.right = TreeNode(14)
    root
  }

  val tree4 = null

  test("sanity") { solution =>
    assert(solution.isSameTree(tree1, tree2) === true)
  }

  test("regression") { solution =>
    assert(solution.isSameTree(tree1, tree3) === false)
    assert(solution.isSameTree(tree4, tree1) === false)
  }

}
