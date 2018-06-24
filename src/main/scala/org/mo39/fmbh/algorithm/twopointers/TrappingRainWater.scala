package org.mo39.fmbh.algorithm.twopointers

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given n non-negative integers representing an elevation map where the
  * width of each bar is 1, compute how much water it is able to trap after
  * raining.
  *
  *
  * The above elevation map is represented by array
  * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue
  * section) are being trapped. Thanks Marcos for contributing this image!
  *
  * Example:
  *
  *
  * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
  * Output: 6
  * }}}
  *
  * @see [[https://leetcode.com/problems/trapping-rain-water/ TrappingRainWater]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait TrappingRainWater {
  def trap(height: Array[Int]): Int
}

object TrappingRainWater extends Enumerable[TrappingRainWater] {

  case object Solution extends TrappingRainWater {
    override def trap(height: Array[Int]): Int = {
      var stack = List[(Int, Int)]() // Height and position of the left barrier
      var sum   = 0
      for (i <- 1 until height.length) {
        if (height(i) < height(i - 1)) { // Left barrier
          stack = (height(i - 1) - height(i), i - 1) :: stack
        } else if (height(i) > height(i - 1)) { // Right barrier
          while (stack.nonEmpty && height(stack.head._2) <= height(i)) { // You got a left barrier to hold water
            val (h, j) = stack.head
            stack = stack.tail
            sum += (i - j - 1) * h
          }
          if (stack.nonEmpty) {
            val (h, j) = stack.head
            stack = (height(j) - height(i), j) :: stack.tail
            sum += (h - (height(j) - height(i))) * (i - j - 1)
          }
        }
      }
      sum
    }
  }

  case object Solution1 extends TrappingRainWater {
    override def trap(height: Array[Int]): Int = ???
  }

}
