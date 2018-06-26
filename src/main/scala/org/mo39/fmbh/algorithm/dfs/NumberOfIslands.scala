package org.mo39.fmbh.algorithm.dfs

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a 2d grid map of '1's (land) and '0's (water), count the number
  * of islands. An island is surrounded by water and is formed by
  * connecting adjacent lands horizontally or vertically. You may assume
  * all four edges of the grid are all surrounded by water.
  *
  * Example 1:
  *
  *
  * Input:
  * 11110
  * 11010
  * 11000
  * 00000
  *
  * Output: 1
  *
  *
  * Example 2:
  *
  *
  * Input:
  * 11000
  * 11000
  * 00100
  * 00011
  *
  * Output: 3
  * }}}
  *
  * @see [[https://leetcode.com/problems/number-of-islands/ NumberOfIslands]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait NumberOfIslands {
  def numIslands(grid: Array[Array[Char]]): Int
}

object NumberOfIslands extends Enumerable[NumberOfIslands] {
  case object Solution extends NumberOfIslands {
    override def numIslands(grid: Array[Array[Char]]): Int = {
      def isValid(i: Int, j: Int): Boolean = i >= 0 && j >= 0 && i < grid.length && j < grid(i).length
      def dfs(i: Int, j: Int): Unit =
        if (isValid(i, j) && grid(i)(j) == '1') {
          grid(i)(j) = '0'
          dfs(i + 1, j)
          dfs(i - 1, j)
          dfs(i, j + 1)
          dfs(i, j - 1)
        }
      var count = 0
      for (i <- grid.indices; j <- grid(i).indices if grid(i)(j) == '1') {
        count += 1
        dfs(i, j)
      }
      count
    }
  }
}
