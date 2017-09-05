package org.mo39.fmbh.datastructure.array

object MaxConsecutiveOnes {

  sealed trait MaxConsecutiveOnes {
    def findMaxConsecutiveOnes(nums: Array[Int]): Int
  }

  object SOLUTION extends MaxConsecutiveOnes {

    override def findMaxConsecutiveOnes(nums: Array[Int]): Int = {
      var (max, pre, count) = (0, 0, 0)
      for (i <- nums) {
        if (i == 0) count = 0
        else count += 1
        max = Math.max(max, count)
        pre = i
      }
      max
    }

  }

}
