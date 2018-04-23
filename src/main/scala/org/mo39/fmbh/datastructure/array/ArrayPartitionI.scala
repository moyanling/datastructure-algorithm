package org.mo39.fmbh.datastructure.array

import scala.util.Sorting

object ArrayPartitionI {

  def arrayPairSum(nums: Array[Int]): Int = {
    var sum = 0
    Sorting.quickSort(nums)
    for (i <- nums.indices if i % 2 == 0) sum += nums(i)
    sum
  }

}
