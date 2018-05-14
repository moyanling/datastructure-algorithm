package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.utils.Z

object MoveZeroes {

  sealed trait MoveZeros {
    def moveZeroes(nums: Array[Int]): Unit
  }

  case object SOLUTION extends MoveZeros {
    override def moveZeroes(nums: Array[Int]): Unit =
      Z.partition(nums, _ != 0)
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(0, 0, 0, 1, 2, 3, 4, 5)
    SOLUTION.moveZeroes(nums)
  }

}
