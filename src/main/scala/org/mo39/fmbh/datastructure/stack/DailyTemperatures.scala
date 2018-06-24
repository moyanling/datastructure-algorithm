package org.mo39.fmbh.datastructure.stack

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  *
  * Given a list of daily temperatures, produce a list that, for each day
  * in the input, tells you how many days you would have to wait until a
  * warmer temperature.  If there is no future day for which this is
  * possible, put 0 instead.
  *
  * For example, given the list temperatures = [73, 74, 75, 71, 69, 72, 76,
  * 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
  *
  *
  * Note:
  * The length of temperatures will be in the range [1, 30000].
  * Each temperature will be an integer in the range [30, 100].
  * }}}
  *
  * @see [[https://leetcode.com/problems/daily-temperatures/ DailyTemperatures]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait DailyTemperatures {
  def dailyTemperatures(temperatures: Array[Int]): Array[Int]
}

object DailyTemperatures extends Enumerable[DailyTemperatures] {
  case object Solution extends DailyTemperatures {
    override def dailyTemperatures(temperatures: Array[Int]): Array[Int] = {
      val result = Array.fill(temperatures.length)(0)
      var stack  = List[(Int, Int)]()
      for ((t, i) <- temperatures.zipWithIndex) {
        if (stack.nonEmpty) {
          while (stack.nonEmpty && stack.head._1 < t) {
            result(stack.head._2) = i - stack.head._2
            stack = stack.tail
          }
        }
        stack = (t, i) :: stack
      }
      result
    }
  }
}
