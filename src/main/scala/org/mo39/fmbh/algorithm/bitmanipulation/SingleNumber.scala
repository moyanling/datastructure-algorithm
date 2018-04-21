package org.mo39.fmbh.algorithm.bitmanipulation

import org.mo39.fmbh.commons.annotations.Sources.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

@LeetCode
sealed trait SingleNumber {
  def singleNumber(nums: Array[Int]): Int
}

object SingleNumber extends Enumerable[SingleNumber] {

  case object Solution extends SingleNumber {
    override def singleNumber(nums: Array[Int]): Int = nums.reduce(_ ^ _)
  }

}
