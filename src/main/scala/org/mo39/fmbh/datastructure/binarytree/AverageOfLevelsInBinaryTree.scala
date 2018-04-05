package org.mo39.fmbh.datastructure.binarytree

import org.mo39.fmbh.commons.classes.TreeNode

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object AverageOfLevelsInBinaryTree {

  sealed trait AverageOfLevelsInBinaryTree {
    def averageOfLevels(root: TreeNode): Array[Double]
  }

  case object SOLOUTION extends AverageOfLevelsInBinaryTree {
    override def averageOfLevels(root: TreeNode): Array[Double] = {
      val result = new ArrayBuffer[Double]()
      if (root == null) return result.toArray
      val q = mutable.Queue[TreeNode](root)
      while (!q.isEmpty) {
        var (sum, size) = (0.0, q.size)
        (0 until size).foreach(_ => {
          val node = q.dequeue
          sum += node.value
          if (node.left != null) q += node.left
          if (node.right != null) q += node.right
        })
        result += sum / size
      }
      result.toArray
    }
  }

}
