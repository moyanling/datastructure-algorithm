package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ArrayBuffer

/**
  * {{{
  * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
  * The cost of painting each house with a certain color is different. You have to paint all the houses
  * such that no two adjacent houses have the same color.
  *
  * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
  * For example,
  * costs[0][0] is the cost of painting house 0 with color red;
  * costs[1][2] is the cost of painting house 1 with color green, and so on...
  * Find the minimum cost to paint all houses.
  *
  * Note:
  * All costs are positive integers.
  *
  * Example:
  *
  * Input: [[17,2,17],[16,16,5],[14,3,19]]
  * Output: 10
  * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
  *              Minimum cost: 2 + 5 + 3 = 10.
  * }}}
  *
  * @see [[https://leetcode.com/problems/paint-house/ PaintHouse]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait PaintHouse {
  def minCost(costs: Array[Array[Int]]): Int
}

object PaintHouse extends Enumerable[PaintHouse] {

  /**
    * When painting THE house, you got three choices.
    */
  case object Solution extends PaintHouse {
    override def minCost(costs: Array[Array[Int]]): Int = {
      val memo = ArrayBuffer(Array(0, 0, 0))
      for (i <- costs.indices) {
        val c = costs(i)
        memo += Array(
          c(0) + math.min(memo(i)(1), memo(i)(2)),
          c(1) + math.min(memo(i)(0), memo(i)(2)),
          c(2) + math.min(memo(i)(0), memo(i)(1))
        )
      }
      memo.last.min
    }
  }
}
