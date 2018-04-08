package org.mo39.fmbh.algorithm.sort

import scala.collection.mutable

sealed trait FindAllNumbersDisappearedInAnArray {

  def findDisappearedNumbers(nums: Array[Int]): List[Int]

}


object Solution1 extends FindAllNumbersDisappearedInAnArray {

  override def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    val result = mutable.ListBuffer[Int]()
    val len = nums.length + 1
    for (i <- nums.indices) {
      val v = nums(i) % len - 1
      nums(v) = nums(v) % len + len
    }
    nums.indices.foreach(i => if (nums(i) <= len) result += i + 1)
    result.toList
  }
}

object Solution2 extends FindAllNumbersDisappearedInAnArray {
  override def findDisappearedNumbers(nums: Array[Int]): List[Int] = {
    val result = mutable.ListBuffer[Int]()
    for (i <- nums.indices) {
      val j = Math.abs(nums(i)) - 1
      nums(j) = -Math.abs(nums(j))
    }
    nums.indices.foreach(i => if (nums(i) > 0) result += i + 1)
    result.toList
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(4, 3, 2, 7, 8, 2, 3, 1)
    println(findDisappearedNumbers(nums))
  }
}