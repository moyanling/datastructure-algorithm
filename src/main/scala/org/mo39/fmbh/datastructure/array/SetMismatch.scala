package org.mo39.fmbh.datastructure.array

object SetMismatch {

  sealed trait SetMismatch {
    def findErrorNums(nums: Array[Int]): Array[Int]
  }

  case object SOLUTION extends SetMismatch {
    override def findErrorNums(nums: Array[Int]): Array[Int] = {
      val dup = nums.sum - nums.distinct.sum
      Array(dup, (0 to nums.length).sum - nums.sum + dup)
    }
  }

}
