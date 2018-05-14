package org.mo39.fmbh.algorithm.graph

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable
import org.mo39.fmbh.commons.utils.Z._

/**
  * {{{
  * Given a non-empty 2D array grid of 0's and 1's, an island is a group of
  * 1's (representing land) connected 4-directionally (horizontal or
  * vertical.)  You may assume all four edges of the grid are surrounded by
  * water.
  *
  * Find the maximum area of an island in the given 2D array.
  * (If there is no island, the maximum area is 0.)
  *
  * Example 1:
  *
  * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
  *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
  *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
  *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
  *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
  *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
  *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
  *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
  *
  * Given the above grid, return 6.
  *
  * Note the answer is not 11, because the island must be connected
  * 4-directionally.
  *
  *
  * Example 2:
  * [[0,0,0,0,0,0,0,0]]
  * Given the above grid, return 0.
  *
  *
  * Note:
  * The length of each dimension in the given grid does not exceed 50.
  * }}}
  *
  * @see [[https://leetcode.com/problems/max-area-of-island/ MaxAreaOfIsland]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MaxAreaOfIsland {
  def maxAreaOfIsland(grid: Array[Array[Int]]): Int
}

object MaxAreaOfIsland extends Enumerable[MaxAreaOfIsland] {

  case object Solution extends MaxAreaOfIsland {
    def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
      var max = 0
      for (i <- grid.indices)
        for (j <- grid(i).indices) max = Math.max(max, dfs(grid, i, j))
      max
    }

    def dfs(grid: Array[Array[Int]], i: Int, j: Int): Int =
      if (!isValid(grid, i, j) || grid(i)(j) == 0) 0
      else {
        grid(i)(j) = 0
        1 +
        dfs(grid, i + 1, j) +
        dfs(grid, i - 1, j) +
        dfs(grid, i, j + 1) +
        dfs(grid, i, j - 1)
      }
  }

}
