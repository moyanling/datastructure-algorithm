package org.mo39.fmbh.algorithm.slidingwindow

import scala.collection.mutable

// TODO
object SlidingWindowMaximum {

  sealed trait SlidingWindowMaximum {
    def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int]
  }

  /***
    * The priority queue in scala does not support remove method.
    * So this problem cannot be done using priority queue in Scala.
    *
    * //TODO need priority queue implementation.
    */
  object SOLUTION extends SlidingWindowMaximum {

    override def maxSlidingWindow(nums: Array[Int], k: Int): Array[Int] = {
      var (window, result) = (nums.slice(0, k), Array.fill(nums.length - k + 1) { 0 })
      var q = new mutable.PriorityQueue[Int]() ++ window
      result
    }

  }

  def main(args: Array[String]): Unit = {
    SOLUTION.maxSlidingWindow(Array(1, 3, -1, -4, 5, 3, 6, 7), 3)
  }

}