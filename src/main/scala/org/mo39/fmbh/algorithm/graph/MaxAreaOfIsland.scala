package org.mo39.fmbh.algorithm.graph

object MaxAreaOfIsland {

  import org.mo39.fmbh.common.Z._

  def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
    var max = 0
    for (i <- grid.indices) for (j <- grid(i).indices) max = Math.max(max, dfs(grid, i, j))
    max
  }

  def dfs(grid: Array[Array[Int]], i: Int, j: Int): Int = {
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

  def main(args: Array[String]): Unit = {
    val grid = Array(Array(1, 1, 0, 0, 0), Array(1, 1, 0, 0, 0), Array(0, 0, 0, 1, 1), Array(0, 0, 0, 1, 1))
    println(MaxAreaOfIsland.maxAreaOfIsland(grid))
  }

}
