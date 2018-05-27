package org.mo39.fmbh.datastructure.stack

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ListBuffer

/**
  * {{{
  * Say you have an array for which the ith element is the price of a given
  * stock on day i.
  *
  * Design an algorithm to find the maximum profit. You may complete as
  * many transactions as you like (i.e., buy one and sell one share of the
  * stock multiple times).
  *
  * Note: You may not engage in multiple transactions at the same time
  * (i.e., you must sell the stock before you buy again).
  *
  * Example 1:
  *
  *
  * Input: [7,1,5,3,6,4]
  * Output: 7
  * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5),
  * profit = 5-1 = 4.
  *              Then buy on day 4 (price = 3) and sell on day 5 (price =
  * 6), profit = 6-3 = 3.
  *
  *
  * Example 2:
  *
  *
  * Input: [1,2,3,4,5]
  * Output: 4
  * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5),
  * profit = 5-1 = 4.
  *              Note that you cannot buy on day 1, buy on day 2 and sell
  * them later, as you are
  *              engaging multiple transactions at the same time. You must
  * sell before buying again.
  *
  *
  * Example 3:
  *
  *
  * Input: [7,6,4,3,1]
  * Output: 0
  * Explanation: In this case, no transaction is done, i.e. max profit = 0.
  * }}}
  *
  * @see [[https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/ BestTimeToBuyAndSellStockII]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait BestTimeToBuyAndSellStockII {
  def maxProfit(prices: Array[Int]): Int
}

object BestTimeToBuyAndSellStockII extends Enumerable[BestTimeToBuyAndSellStockII] {
  case object Solution extends BestTimeToBuyAndSellStockII {
    override def maxProfit(prices: Array[Int]): Int = {
      var (profit, stack) = (0, ListBuffer[Int]())
      for (i <- prices.indices) {
        if (stack.isEmpty || stack.last < prices(i)) stack += prices(i)
        else {
          profit += stack.last - stack.head
          stack = ListBuffer(prices(i))
        }
      }
      (if (stack.nonEmpty) stack.last - stack.head else 0) + profit
    }
  }
}
