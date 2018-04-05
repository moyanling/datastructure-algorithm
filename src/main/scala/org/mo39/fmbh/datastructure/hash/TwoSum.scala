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

  def main(args: Array[String]): Unit = {
    val nums = Array(2, 7, 11, 15)
    println(twoSum(nums, 9).mkString(", "))
  }

}
