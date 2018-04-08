package org.mo39.fmbh.datastructure.hash


object TwoSum {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = nums.zipWithIndex.toMap
    for (i <- nums.indices) {
      if (i != map.getOrElse(target - nums(i), i))
        return Array(i, map(target - nums(i)))
    }
    Array()
  }

}
