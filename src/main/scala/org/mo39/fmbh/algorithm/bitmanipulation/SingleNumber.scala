
package org.mo39.fmbh.algorithm.bitmanipulation

object SingleNumber {

  sealed trait SingleNumber {
    def singleNumber(nums: Array[Int]): Int
  }

  case object SOLUTION extends SingleNumber {

    override def singleNumber(nums: Array[Int]): Int = {
      nums.reduce(_ ^ _)
    }

  }

}