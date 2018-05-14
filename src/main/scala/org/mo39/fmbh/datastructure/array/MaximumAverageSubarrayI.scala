package org.mo39.fmbh.datastructure.array

object MaximumAverageSubarrayI {

  def main(args: Array[String]): Unit =
    print(findMaxAverage(Array(1, 12, -5, -6, 50, 3), 4))

  def findMaxAverage(nums: Array[Int], k: Int): Double = {
    var sum = 0
    for (i <- 0 until k) sum += nums(i)
    var max = sum
    for (i <- 0 until nums.length - k) {
      sum -= nums(i) - nums(i + k)
      max = Math.max(max, sum)
    }
    return max.toDouble / k
  }

}
