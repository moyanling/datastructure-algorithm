package org.mo39.fmbh.datastructure.array

object MissingNumber {

  sealed trait MissingNumber {
    def missingNUmber(nums: Array[Int]): Int
  }

  case object SOLUTION extends MissingNumber {
    override def missingNUmber(nums: Array[Int]): Int = {
      (0 + nums.length) * (nums.length + 1) / 2 - nums.sum
    }
  }

}
