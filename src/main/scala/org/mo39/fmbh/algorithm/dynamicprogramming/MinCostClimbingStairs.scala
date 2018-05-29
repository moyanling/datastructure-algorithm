package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  *
  * On a staircase, the i-th step has some non-negative cost cost[i]
  * assigned (0 indexed).
  *
  * Once you pay the cost, you can either climb one or two steps. You need
  * to find minimum cost to reach the top of the floor, and you can either
  * start from the step with index 0, or the step with index 1.
  *
  *
  * Example 1:
  *
  * Input: cost = [10, 15, 20]
  * Output: 15
  * Explanation: Cheapest is start on cost[1], pay that cost and go to the
  * top.
  *
  *
  *
  * Example 2:
  *
  * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
  * Output: 6
  * Explanation: Cheapest is start on cost[0], and only step on 1s,
  * skipping cost[3].
  *
  *
  *
  * Note:
  *
  * cost will have a length in the range [2, 1000].
  * Every cost[i] will be an integer in the range [0, 999].
  * }}}
  *
  * @see [[https://leetcode.com/problems/min-cost-climbing-stairs/ MinCostClimbingStairs]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MinCostClimbingStairs {
  def minCostClimbingStairs(cost: Array[Int]): Int
}

object MinCostClimbingStairs extends Enumerable[MinCostClimbingStairs] {

  /**
    * The state of the result depends on the state of previous two results.
    */
  case object Solution extends MinCostClimbingStairs {
    override def minCostClimbingStairs(cost: Array[Int]): Int = {
      val memo = new Array[Int](cost.length + 2)
      for (i <- cost.indices) {
        memo(i + 2) = math.min(memo(i + 1), memo(i)) + cost(i)
      }
      memo.takeRight(2).min
    }
  }
}
