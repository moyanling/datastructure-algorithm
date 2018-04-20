package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.utils.Z

object ReshapeTheMatrix {

  sealed trait ReshapeTheMatrix {
    def matrixReshape(nums: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]]
  }

  case object SOLUTION extends ReshapeTheMatrix {

    override def matrixReshape(nums: Array[Array[Int]], r: Int, c: Int): Array[Array[Int]] = {
      if (nums == null || nums(0).length < 1 || r * c != nums.length * nums(0).length) return nums
      val result = Array.ofDim[Int](r, c)
      (0 until r * c).foreach(i => result(i / c)(i % c) = nums(i / nums(0).length)(i % nums(0).length))
      result
    }

  }

  def main(args: Array[String]): Unit = {
    Z.print(SOLUTION.matrixReshape(Array.ofDim[Int](1, 5), 5, 1))
  }


}
